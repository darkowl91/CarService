package com.motors.model.auto;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BODY_TYPE", schema = "carservice")
public class BodyType extends BaseEntity {

    @Column(name = "TYPE_NAME")
    private String typeName;

    public BodyType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
