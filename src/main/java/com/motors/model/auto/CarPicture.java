package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_PICTURE", schema = "carservice")
public class CarPicture extends BaseEntity {

    @Column(name = "PICTURE_NAME")
    private String pictureName;

    @ManyToOne
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
