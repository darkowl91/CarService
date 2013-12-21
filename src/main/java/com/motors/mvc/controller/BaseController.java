package com.motors.mvc.controller;

import com.motors.mvc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public abstract class BaseController {

    @Autowired
    protected IAccountService accountService;

}
