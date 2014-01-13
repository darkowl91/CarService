package com.motors.mvc.service;

import com.motors.model.auto.BodyType;
import com.motors.model.auto.CarBrand;
import com.motors.model.auto.CarModel;
import com.motors.model.auto.Transmission;

import java.util.List;

public interface ICarService {

    List<CarBrand> getAvailableBrands();

    List<BodyType> getAvailableBodyTypes();

    List<Transmission> getAvailableTransmissionTypes();

    CarBrand getBrandById(Long id);

    CarModel getCarModelById(Long id);

    BodyType getBodyTypeById(Long id);

}
