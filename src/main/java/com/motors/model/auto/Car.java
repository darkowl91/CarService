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
}
