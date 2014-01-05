package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "CAR", schema = "carservice")
public class Car extends BaseEntity {

    @Column(name = "PRODUCE_YEAR")
    private Date produceYear;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    private CarBrand brand;

    @ManyToOne
    private CarModel model;

    @OneToOne
    private BodyType body;

    @Column(name = "TRANSMISSION")
    private Transmission transmission;

    @OneToMany(mappedBy = "car")
    private List<CarPicture> pictures;

    public Car() {
    }

    public Date getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(Date produceYear) {
        this.produceYear = produceYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
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
