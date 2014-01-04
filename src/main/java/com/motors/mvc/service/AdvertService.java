package com.motors.mvc.service;

import com.motors.dao.BaseEntityDao;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IAdvertService")
@Transactional
public class AdvertService implements IAdvertService {

    BaseEntityDao<Car> carDao;
    BaseEntityDao<Advt> advtDao;

    @Autowired
    public void setDao(BaseEntityDao<Car> carDao, BaseEntityDao<Advt> advtDao) {
        this.advtDao = advtDao;
        this.advtDao.setClazz(Advt.class);
        this.carDao = carDao;
        this.carDao.setClazz(Car.class);
    }
}
