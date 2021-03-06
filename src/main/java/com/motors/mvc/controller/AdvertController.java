package com.motors.mvc.controller;

import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.*;
import com.motors.programm.nav.BreadCrumbs;
import com.motors.programm.nav.PageImpl;
import com.motors.programm.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Controller
public class AdvertController extends BaseController {

    @RequestMapping(value = "/carService/adverts")
    public String advertsList(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("adverts", "/carService/adverts", "carService.adverts"));
        modelMap.put(PageImpl.BEAN_NAME, advertService.getNextPage(1, 10));
        return "carService.adverts";
    }

    @RequestMapping(value = "/carService/sale")
    public String newAdvert(ModelMap modelMap, HttpSession session) {
        if (session.getAttribute("advt") == null) {
            session.setAttribute("advt", advertService.getNewAdvtInstance((User) session.getAttribute("user")));
        }
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        modelMap.put("brands", carService.getAvailableBrands());
        modelMap.put("bodyTypes", carService.getAvailableBodyTypes());
        modelMap.put("transmissions", carService.getAvailableTransmissionTypes());
        return "carService.sale";
    }

    @RequestMapping(value = "/carService/sale/ajax", method = RequestMethod.POST)
    @ResponseBody
    public List<CarModel> getModels(@RequestParam(value = "brandId") String id) {
        CarBrand carBrand = carService.getBrandById(Long.valueOf(id));
        return carBrand.getModels();
    }

    @RequestMapping(value = "/next")
    public String newAdvert(HttpSession session,
                            @RequestParam(value = "brand", required = false) String mark,
                            @RequestParam(value = "model", required = false) String model,
                            @RequestParam(value = "body", required = false) String body,
                            @RequestParam(value = "transmission", required = false) String transmission) {
        Advt advt = (Advt) session.getAttribute("advt");
        if (!body.isEmpty()) {
            advt.getCar().setBody(carService.getBodyTypeById(Long.valueOf(body)));
        }
        if (model != null) {
            advt.getCar().setModel(carService.getCarModelById(Long.valueOf(model)));
        }
        if (transmission != null) {
            advt.getCar().setTransmission(Transmission.valueOf(transmission));
        }
        return "redirect:/carService/sale/next";
    }

    @RequestMapping(value = "/carService/sale/next")
    public String newAdvertNext(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("sale", "/carService/sale", "carService.sale"));
        return "carService.sale.next";
    }

    @RequestMapping(value = "/next/next")
    public String newAdvertNextNext(HttpSession session,
                                    @RequestParam(value = "year", required = false) String year,
                                    @RequestParam(value = "price", required = false) String price,
                                    @RequestParam(value = "photo", required = false) List<MultipartFile> photos,
                                    @RequestParam(value = "note", required = false) String note) throws ParseException {
        Advt advt = (Advt) session.getAttribute("advt");
        if (advt == null){
            return "redirect:/carService/sale/next";
        }
        Car advtCar = advt.getCar();
        if (year != null) {
            advtCar.setProduceYear(DateUtil.parseDate(year, DateUtil.PATTERN_YYYY));
        }
        if (price != null && !price.isEmpty()) {
            advtCar.setPrice(new BigDecimal(Double.valueOf(price)));
        }
        //TODO: check file size
        try {
            for (MultipartFile photo : photos) {
                advtCar.getPictures().add(new CarPicture(photo.getName(), photo.getBytes(), advtCar));
            }
        } catch (IOException e) {
            LOG.error("Upload user photo", e);
        }
        advt.setNote(note);
        advertService.saveAdvt(advt);
        session.removeAttribute("advt");
        return "redirect:/carService/sale/next";
    }

    @RequestMapping(value = "/carService/adverts/page")
    public String nextPage(@RequestParam(value = "pageNumber") String pageNumber, ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("adverts", "/carService/adverts", "carService.adverts"));
        modelMap.put(PageImpl.BEAN_NAME, advertService.getNextPage(Integer.valueOf(pageNumber), 10));
        return "carService.adverts";
    }

    @RequestMapping(value = "/carService/manageAdvts")
    public String manageAdvts(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("manageAdvts", "/carService/manageAdvts", "carService.adverts.manage"));
        modelMap.put("advtToDelete", advertService.getAdvtToDelete());
        modelMap.put("advtToVerifyCount", advertService.getAdvtToVerify().size());
        return "carService.adverts.manage";
    }

    @RequestMapping(value = "/carService/manageAdvts/verify")
    public String verifyAdvts(ModelMap modelMap) {
        modelMap.put(BreadCrumbs.BEAN_NAME, new BreadCrumbs("manageAdvts", "/carService/manageAdvts", "carService.adverts.manage"));
        modelMap.put("advtToVerify", advertService.getAdvtToVerify());
        modelMap.put("advtToVerifyCount", advertService.getAdvtToVerify().size());
        return "carService.adverts.manage.verify";
    }

    @RequestMapping(value = "/advtVerify")
    public String verifyAdvt(@RequestParam(value = "advtId") String advtId) {
        Advt advt = advertService.getAdvtById(Long.valueOf(advtId));
        advt.setVerified(true);
        advertService.saveUpdateAdvt(advt);
        return "redirect: /carService/manageAdvts/verify";
    }

    @RequestMapping(value = "/advtDelete")
    public String deleteAdvt(@RequestParam(value = "advtId") String advtId) {
        Advt advt = advertService.getAdvtById(Long.valueOf(advtId));
        advertService.deleteAdvt(advt);
        return "redirect: /carService/manageAdvts";
    }
}