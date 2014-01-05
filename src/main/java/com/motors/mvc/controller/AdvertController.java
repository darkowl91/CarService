package com.motors.mvc.controller;

import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.CarBrand;
import com.motors.model.auto.CarModel;
import com.motors.model.auto.Transmission;
import com.motors.programm.nav.BreadCrumbs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String newAdvert(ModelMap modelMap, HttpSession session) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        modelMap.put("brands", advertService.getAvailableBrands());
        modelMap.put("bodyTypes", advertService.getAvailableBodyTypes());
        modelMap.put("transmissions", advertService.getAvailableTransmissionTypes());
        session.setAttribute("advt", advertService.getNewAdvtInstance((User) session.getAttribute("user")));
        return "carService.sale";
    }

    @RequestMapping(value = "/carService/sale/ajax", method = RequestMethod.POST)
    @ResponseBody
    public List<CarModel> getModelsByBrand(@RequestParam(value = "brand") String brand) {
        CarBrand carBrand = advertService.getBrandByName(brand);
        List<CarModel> models = advertService.getModelByBrand(carBrand);
        return models;
    }

    @RequestMapping(value = "/next")
    public String newAdvertNext(ModelMap modelMap, HttpSession session,
                                @RequestParam(value = "mark") String mark,
                                @RequestParam(value = "model") String model,
                                @RequestParam(value = "body") String body,
                                @RequestParam(value = "transmission") String transmission) {
        Advt advt = (Advt) session.getAttribute("advt");
        advt.getCar().setBrand(advertService.getBrandByName(mark));
        //TODO: find solution not to repeat model with brand
        //advt.getCar().setModel();
        advt.getCar().setBody(advertService.getBodyTypeByName(body));
        advt.getCar().setTransmission(Transmission.valueOf(transmission));


//        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        return "carService.sale";
    }


}