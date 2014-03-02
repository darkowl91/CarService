package com.motors.mvc.controller;

import com.motors.model.advertisement.Advt;
import com.motors.model.auto.Transmission;
import com.motors.programm.nav.BreadCrumbs;
import com.motors.programm.nav.Page;
import com.motors.programm.nav.PageImpl;
import com.motors.programm.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController extends BaseController {

    @RequestMapping(value = "/carService/searchAdvert")
    public String search(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("searchAdvert", "/carService/searchAdvert", "carService.searchAdvert"));

        modelMap.put(PageImpl.BEAN_NAME, advertService.getNextPage(1, 10));

        modelMap.put("brands", carService.getAvailableBrands());
        modelMap.put("bodyTypes", carService.getAvailableBodyTypes());
        modelMap.put("transmissions", carService.getAvailableTransmissionTypes());
        return "carService.searchAdvert";
    }

    @RequestMapping(value = "/carService/searchAdvert/search")
    public String searchAdvt(ModelMap modelMap,
                             @RequestParam(value = "brand", required = false) String brand,
                             @RequestParam(value = "model", required = false) String model,
                             @RequestParam(value = "year", required = false) String year,
                             @RequestParam(value = "body", required = false) String body,
                             @RequestParam(value = "transmission", required = false) String transmission,
                             @RequestParam(value = "price_from", required = false) String priseFrom,
                             @RequestParam(value = "price_to", required = false) String priceTo) {

        Map<String, Object> prms = new HashMap<String, Object>();
        if (!brand.isEmpty()) {
            prms.put("brand", Long.valueOf(brand));
        }
        if (!model.isEmpty()) {
            prms.put("model", Long.valueOf(model));
        }
        if (!year.isEmpty()) {
            prms.put("year", DateUtil.getSqlDateYear(year));
        }
        if (!body.isEmpty()) {
            prms.put("body", Long.valueOf(body));
        }
        if (!transmission.isEmpty()) {
            prms.put("transmission", Transmission.valueOf(transmission));
        }
        if (!priseFrom.isEmpty()) {
            prms.put("price_from", BigDecimal.valueOf(Double.valueOf(priseFrom)));
        }
        if (!priceTo.isEmpty()) {
            prms.put("price_to", BigDecimal.valueOf(Double.valueOf(priceTo)));
        }

        List<Advt> advts = advertService.search(prms);

        Page<Advt> page = new PageImpl<Advt>(advts,1,advts.size(),advts.size());
        modelMap.put(PageImpl.BEAN_NAME, page);
        modelMap.put("brands", carService.getAvailableBrands());
        modelMap.put("bodyTypes", carService.getAvailableBodyTypes());
        modelMap.put("transmissions", carService.getAvailableTransmissionTypes());
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("searchAdvert", "/carService/searchAdvert/search", "carService.searchAdvert"));

        return "carService.searchAdvert";
    }

//    @RequestMapping(value = "/carService/searchAdvert/result")
//    public String searchResult(ModelMap modelMap) {
//        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("searchAdvert", "/carService/searchAdvert", "carService.searchAdvert"));
//        return "carService.searchAdvert";
//    }

}
