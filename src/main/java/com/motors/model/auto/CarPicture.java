package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_PICTURE", schema = "carservice")
public class CarPicture extends BaseEntity {
    private String pictureName;
    private Car car;

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
