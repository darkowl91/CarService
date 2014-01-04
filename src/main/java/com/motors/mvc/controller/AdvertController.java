package com.motors.mvc.controller;

import com.motors.programm.nav.BreadCrumbs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdvertController extends BaseController {

    @RequestMapping(value = "/carService/searchAdvert")
    public String search(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("searchAdvert", "/carService/searchAdvert", "carService.searchAdvert"));
        return "carService.searchAdvert";
    }

    @RequestMapping(value = "/carService/adverts")
    public String advertsList(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("adverts", "/carService/adverts", "carService.adverts"));
        return "carService.adverts";
    }

    @RequestMapping(value = "/carService/sale")
    public String newAdvert(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        return "carService.sale";
    }

    @RequestMapping(value = "/next")
    public String newAdvertNext(ModelMap modelMap, HttpSession session,
                                @RequestParam(value = "mark") String mark,
                                @RequestParam(value = "model") String model,
                                @RequestParam(value = "body") String body,
                                @RequestParam(value = "transmission") String transmission) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        return "carService.sale";
    }


}