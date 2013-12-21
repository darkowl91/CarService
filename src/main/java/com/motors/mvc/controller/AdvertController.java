package com.motors.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdvertController extends BaseController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String startPage() {
        return "start";
    }
}