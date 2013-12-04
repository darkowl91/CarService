package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "CAR", schema = "carservice")
public class Car extends BaseEntity {
    private Date produceYear;
    private BigDecimal price;
    private CarModel model;
    private BodyType body;
    private Transmission transmission;
    private List<CarPicture> pictures;

    @Column(name = "PRODUCE_YEAR")
    public Date getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(Date pauseYear) {
        this.produceYear = pauseYear;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    @OneToOne
    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    @Column(name = "TRANSMISSION")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @OneToMany
    public List<CarPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<CarPicture> pictures) {
        this.pictures = pictures;
    }
}
