package com.motors.mvc.controller;

import com.motors.mvc.service.IAccountService;
import com.motors.programm.nav.BreadCrumbs;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public abstract class BaseController {

    protected Logger LOG = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected IAccountService accountService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String startPage(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("adverts", "/", "carService.adverts"));
        return "carService.adverts";
    }

}
