package com.motors.mvc.service;

import com.motors.dao.BaseEntityDao;
import com.motors.model.auto.BodyType;
import com.motors.model.auto.CarBrand;
import com.motors.model.auto.CarModel;
import com.motors.model.auto.Transmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("ICarService")
@Transactional
public class CarService implements ICarService {

    BaseEntityDao<CarBrand> carBrandDao;
    BaseEntityDao<BodyType> bodyTypeDao;
    BaseEntityDao<CarModel> carModelDao;

    @Autowired
    public void setDao(BaseEntityDao<CarBrand> carBrandDao,
                       BaseEntityDao<BodyType> bodyTypeDao,
                       BaseEntityDao<CarModel> carModelDao) {
        this.carBrandDao = carBrandDao;
        this.carBrandDao.setClazz(CarBrand.class);
        this.bodyTypeDao = bodyTypeDao;
        this.bodyTypeDao.setClazz(BodyType.class);
        this.carModelDao = carModelDao;
        this.carModelDao.setClazz(CarModel.class);
    }


    @Override
    public List<CarBrand> getAvailableBrands() {
        return carBrandDao.getAll();
    }

    @Override
    public CarBrand getBrandById(Long id) {
        return carBrandDao.getById(id);
    }

    @Override
    public List<BodyType> getAvailableBodyTypes() {
        return bodyTypeDao.getAll();
    }

    @Override
    public BodyType getBodyTypeById(Long id) {
        return bodyTypeDao.getById(id);
    }

    @Override
    public CarModel getCarModelById(Long id) {
        return carModelDao.getById(id);
    }

    @Override
    public List<Transmission> getAvailableTransmissionTypes() {
        List<Transmission> transmissions = new ArrayList<Transmission>();
        Collections.addAll(transmissions, Transmission.AUTO, Transmission.COMBINED, Transmission.MANUAL);
        return transmissions;
    }
}
