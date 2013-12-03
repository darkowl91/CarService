package com.motors.model.auto;

import com.motors.model.BaseEntity;

import java.util.List;

/**
 * User: Owl
 * Date: 03.12.13
 * Time: 23:40
 */
public class CarBrand extends BaseEntity {
    private List<CarModel> models;
    private String brandName;

    public List<CarModel> getModels() {
        return models;
    }

    public void setModels(List<CarModel> models) {
        this.models = models;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
