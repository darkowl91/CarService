package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "CAR", schema = "carservice")
public class Car extends BaseEntity {

    @Column(name = "PRODUCE_YEAR")
    private Calendar produceYear;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    private CarModel model;

    @OneToOne
    private BodyType body;

    @Column(name = "TRANSMISSION")
    private Transmission transmission;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CarPicture> pictures;

    public Car() {
    }

    public Calendar getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(Calendar produceYear) {
        this.produceYear = produceYear;
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

    public Set<CarPicture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<CarPicture> pictures) {
        this.pictures = pictures;
    }
}
