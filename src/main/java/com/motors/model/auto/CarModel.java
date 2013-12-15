package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CAR_MODEL", schema = "carservice")
public class CarModel extends BaseEntity {

    @ManyToOne
    private CarBrand brand;

    @Column(name = "MODEL_NAME")
    private String modelName;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


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
