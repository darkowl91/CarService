package com.motors.model.advertisement;

import com.motors.model.BaseEntity;
import com.motors.model.account.User;
import com.motors.model.auto.Car;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "ADVERTISMENT", schema = "carservice")
public class Advt extends BaseEntity {

    @ManyToOne(cascade = CascadeType.MERGE )
    private User user;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Car car;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "VERIFIED")
    private boolean verified;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    public Advt() {
        date = Calendar.getInstance();
    }

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

    public Long getDate() {
        return date.getTimeInMillis();
    }

    public void setDate(Long date) {
        this.date.setTimeInMillis(date);
    }
}
