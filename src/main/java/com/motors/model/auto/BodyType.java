package com.motors.model.auto;

import com.motors.model.BaseEntity;

/**
 * User: Owl
 * Date: 03.12.13
 * Time: 23:50
 */
public class BodyType extends BaseEntity {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
