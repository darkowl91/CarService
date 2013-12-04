package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_MODEL", schema = "carservice")
public class CarModel extends BaseEntity {
    private CarBrand brand;
    private String modelName;


    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    @Column(name = "MODEL_NAME")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
