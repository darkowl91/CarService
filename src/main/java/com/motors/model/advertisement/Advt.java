package com.motors.model.advertisement;

import com.motors.model.BaseEntity;
import com.motors.model.account.User;
import com.motors.model.auto.Car;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ADVERTISMENT", schema = "carservice")
public class Advt extends BaseEntity {

    @ManyToOne(cascade=CascadeType.ALL)
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    private Car car;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "VERIFIED")
    private boolean verified;

    @Column(name = "DATE")
    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
