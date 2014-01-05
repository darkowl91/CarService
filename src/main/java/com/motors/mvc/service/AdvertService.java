package com.motors.mvc.service;

import com.motors.dao.BaseEntityDao;
import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.*;
import com.motors.programm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("IAdvertService")
@Transactional
public class AdvertService implements IAdvertService {

    BaseEntityDao<Car> carDao;
    BaseEntityDao<Advt> advtDao;
    BaseEntityDao<CarBrand> carBrandDao;
    BaseEntityDao<BodyType> bodyTypeDao;
    BaseEntityDao<CarModel> carModelDao;


    @Autowired
    public void setDao(BaseEntityDao<Car> carDao, BaseEntityDao<Advt> advtDao,
                       BaseEntityDao<CarBrand> carBrandDao, BaseEntityDao<BodyType> bodyTypeDao,
                       BaseEntityDao<CarModel> carModelDao) {
        this.advtDao = advtDao;
        this.advtDao.setClazz(Advt.class);
        this.carDao = carDao;
        this.carDao.setClazz(Car.class);
        this.carBrandDao = carBrandDao;
        this.carBrandDao.setClazz(CarBrand.class);
        this.bodyTypeDao = bodyTypeDao;
        this.bodyTypeDao.setClazz(BodyType.class);
        this.carModelDao = carModelDao;
        this.carModelDao.setClazz(CarModel.class);
    }


    @Override
    public Advt getNewAdvtInstance(User user) {
        Advt advt = new Advt();
        advt.setDate(DateUtil.getDateNow());
        advt.setCar(new Car());
        advt.setVerified(false);
        advt.setUser(user);
        return advt;
    }

    @Override
    public List<CarBrand> getAvailableBrands() {
        return carBrandDao.getAll();
    }

    @Override
    public CarBrand getBrandByName(String mark) {
        return carBrandDao.getByNamedQuery("FROM CarBrand WHERE brandName=:mark", mark).get(0);
    }

    @Override
    public List<CarModel> getModelByBrand(CarBrand carBrand) {
        return carModelDao.getByNamedQuery("FROM CarModel WHERE brand=:carBrand", carBrand);
    }

    @Override
    public List<BodyType> getAvailableBodyTypes() {
        return bodyTypeDao.getAll();
    }

    @Override
    public BodyType getBodyTypeByName(String body) {
        return bodyTypeDao.getByNamedQuery("FROM BodyType WHERE typeName=:body", body).get(0);
    }

    @Override
    public List<Transmission> getAvailableTransmissionTypes() {
        List<Transmission> transmissions = new ArrayList<Transmission>();
        Collections.addAll(transmissions, Transmission.AUTO, Transmission.COMBINED, Transmission.MANUAL);
        return transmissions;
    }
}
