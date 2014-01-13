package com.motors.mvc.service;

import com.motors.dao.BaseEntityDao;
import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.Car;
import com.motors.model.auto.CarPicture;
import com.motors.programm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("IAdvertService")
@Transactional
public class AdvertService implements IAdvertService {

    BaseEntityDao<Advt> advtDao;


    @Autowired
    public void setDao(BaseEntityDao<Advt> advtDao) {
        this.advtDao = advtDao;
        this.advtDao.setClazz(Advt.class);
    }

    @Override
    public Advt getNewAdvtInstance(User user) {
        Advt advt = new Advt();
        advt.setDate(DateUtil.getDateNow());
        Car car = new Car();
        car.setPictures(new ArrayList<CarPicture>());
        advt.setCar(car);
        advt.setVerified(false);
        advt.setUser(user);
        return advt;
    }

    @Override
    public void saveAdvt(Advt advt) {
        advtDao.saveUpdate(advt);
    }
}
