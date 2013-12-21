package com.motors.mvc.controller;

import com.motors.mvc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public abstract class BaseController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String startPage() {
        return "start";
    }

    @Autowired
    protected IAccountService accountService;

}
