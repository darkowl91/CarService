package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CAR_BRAND", schema = "carservice")
public class CarBrand extends BaseEntity {

    @OneToMany(mappedBy = "brand")
    private List<CarModel> models;

    @Column(name = "BRAND_NAME")
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
