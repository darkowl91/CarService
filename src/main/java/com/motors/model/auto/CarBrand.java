package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CAR_BRAND", schema = "carservice")
public class CarBrand extends BaseEntity {

    private static final long serialVersionUID = -4567263216385823455L;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<CarModel> models;

    @Column(name = "BRAND_NAME")
    private String brandName;

    public CarBrand() {
    }

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
