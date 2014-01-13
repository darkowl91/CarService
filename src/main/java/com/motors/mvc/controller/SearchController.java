package com.motors.mvc.controller;

import com.motors.programm.nav.BreadCrumbs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController extends BaseController {

    @RequestMapping(value = "/carService/searchAdvert")
    public String search(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("searchAdvert", "/carService/searchAdvert", "carService.searchAdvert"));
        modelMap.put("brands", carService.getAvailableBrands());
        modelMap.put("bodyTypes", carService.getAvailableBodyTypes());
        modelMap.put("transmissions", carService.getAvailableTransmissionTypes());
        return "carService.searchAdvert";
    }


}
