package com.motors.mvc.controller;

import com.motors.model.account.Authority;
import com.motors.model.account.Phone;
import com.motors.model.account.User;
import com.motors.programm.nav.BreadCrumbs;
import com.motors.programm.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Controller
public class AccountController extends BaseController {


    @RequestMapping(value = "/logIn")
    public String logIn(HttpSession session, Principal principal) {
        User user = accountService.getLoginPerson(principal.getName());
        session.setAttribute("user", user);
        //TODO: need to return to last page
        return "redirect:/carService/adverts";
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        //TODO: need to return to last page
        return "redirect:/carService/adverts";
    }

    @RequestMapping(value = "/carService/register")
    public String register(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME,
                new BreadCrumbs("register", "/carService/register", "carService.registration"));

        return "carService.registration";
    }

    @RequestMapping(value = "/carService/profileSettings")
    public String settings(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME,
                new BreadCrumbs("profileSettings", "/carService/profileSettings", "carService.profileSettings"));
        return "carService.profileSettings";
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfileSettings(HttpSession session, HttpServletRequest request,
                                      @RequestParam(value = "birthday") String birthday) {
        User user = (User) session.getAttribute("user");
        for (int i = 0; i < 2; i++) {
            String operator = request.getParameter("operator_" + i);
            String number = request.getParameter("number_" + i);
            String type = request.getParameter("type_" + i);
            user.getPhones().add(new Phone(operator, number, type, user));
        }
        user.setBirthDay(DateUtil.getSqlDateByStrValue(birthday));
        accountService.saveUser(user);

        return "redirect: /carService/profileSettings";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewAccount(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "surname") String surname,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "password1") String password1,
                                     @RequestParam(value = "password2") String password2,
                                     @RequestParam(value = "username") String username,
                                     @RequestParam(value = "photo") MultipartFile photo) {
        User userInstance = accountService.getNewUserInstance(Authority.ROLE_USER);
        userInstance.setFirstName(name);
        userInstance.setLastName(surname);
        userInstance.setEmail(email);
        if (password1.equals(password2)) {
            userInstance.setPassword(password2);
        }
        userInstance.setUsername(username);
        //TODO: check file size limit before save
        try {
            userInstance.getPicture().setImage(photo.getBytes());
            userInstance.getPicture().setPictureName(photo.getName());
        } catch (IOException e) {
            LOG.error("Upload user photo", e);
        }
        userInstance.setRegistrationDate(DateUtil.getDateNow());
        accountService.saveUser(userInstance);

        return "redirect:/carService/register";
    }
}
