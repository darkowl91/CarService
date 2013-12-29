package com.motors.mvc.controller;

import com.motors.model.account.User;
import com.motors.programm.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Controller
public class AccountController extends BaseController {


    @RequestMapping(value = "/logIn")
    public String logIn(HttpSession session, Principal principal) {
        User user = accountService.getLoginPerson(principal.getName());
        session.setAttribute("user", user);
        return "start";
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "start";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewAccount(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "surname") String surname,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "password1") String password1,
                                     @RequestParam(value = "password2") String password2,
                                     @RequestParam(value = "username") String username,
                                     @RequestParam(value = "photo") MultipartFile photo) {
        User userInstance = accountService.getNewUserInstance();
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
            LOGG.error("Upload user photo", e);
        }
        userInstance.setRegistrationDate(DateUtil.getDateNow());
        accountService.saveUser(userInstance);

        return "start";
    }
}
