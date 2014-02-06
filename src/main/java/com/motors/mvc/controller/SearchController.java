package com.motors.mvc.controller;

import com.motors.programm.nav.BreadCrumbs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/searchAdvt")
    public String searchAdvt(HttpSession session,
                             @RequestParam(value = "brand") String brand,
                             @RequestParam(value = "model") String model,
                             @RequestParam(value = "year") String year,
                             @RequestParam(value = "body") String body,
                             @RequestParam(value = "transmission") String transmission,
                             @RequestParam(value = "price_from") String priseFrom,
                             @RequestParam(value = "price_to") String priceTo) {


        return "redirect:/carService/searchAdvert";
    }

}
