package com.motors.model.auto;

import com.motors.model.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_MODEL", schema = "carservice")
public class CarModel extends BaseEntity {

    @JsonIgnore
    @ManyToOne
    private CarBrand brand;

    @Column(name = "MODEL_NAME")
    private String modelName;

    public CarModel() {
    }

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
