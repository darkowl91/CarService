package com.motors.model.auto;

import com.motors.model.BaseEntity;

/**
 * User: Owl
 * Date: 03.12.13
 * Time: 23:41
 */
public class CarModel extends BaseEntity {
    private CarBrand brand;
    private String modelName;

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
