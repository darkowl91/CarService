package com.motors.mvc.service;

import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.BodyType;
import com.motors.model.auto.CarBrand;
import com.motors.model.auto.CarModel;
import com.motors.model.auto.Transmission;

import java.util.List;

public interface IAdvertService {

    Advt getNewAdvtInstance(User user);


    void saveAdvt(Advt advt);

}
