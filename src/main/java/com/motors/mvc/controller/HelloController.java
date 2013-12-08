package com.motors.mvc.controller;

import com.motors.model.account.User;
import com.motors.mvc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private IAccountService acountservice;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
//        User user = acountservice.getLoginPerson("sa");
//        user.setEnabled(true);
        return "start";
    }
}