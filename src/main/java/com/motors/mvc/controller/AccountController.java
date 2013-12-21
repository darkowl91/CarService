package com.motors.mvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController extends BaseController {


    @RequestMapping(value = "/logIn")
    public String logIn(HttpSession session) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("user", user);
        accountService.getLoginPerson(user.getUsername());

        return "start";
    }


}
