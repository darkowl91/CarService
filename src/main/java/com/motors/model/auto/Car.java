package com.motors.model.auto;

import com.motors.model.BaseEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * User: Owl
 * Date: 03.12.13
 * Time: 23:35
 */
public class Car extends BaseEntity {
    private CarBrand brand;
    private Date pduceYear;
    private BigDecimal price;
    private CarModel model;
    private BodyType body;
    private Transmission transmission;
    private List<CarPicture> pictures;

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public Date getPduceYear() {
        return pduceYear;
    }

    public void setPduceYear(Date pduceYear) {
        this.pduceYear = pduceYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public List<CarPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<CarPicture> pictures) {
        this.pictures = pictures;
    }
}
