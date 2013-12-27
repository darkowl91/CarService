package com.motors.mvc.controller;

import com.motors.model.account.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
}
