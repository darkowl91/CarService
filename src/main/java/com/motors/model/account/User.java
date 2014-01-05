package com.motors.model.account;

import com.motors.model.BaseEntity;
import com.motors.model.advertisement.Advt;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "USER", schema = "carservice")
public class User extends BaseEntity {

    @Column(name = "USERNAME")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private UserPicture picture;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "BIRTHDAY")
    private Date birthDay;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Authority> authorities;

    @OneToMany(mappedBy = "user")
    private List<Advt> advts;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserPicture getPicture() {
        return picture;
    }

    public void setPicture(UserPicture picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Authority> getAuthority() {
        return authorities;
    }

    public void setAuthority(List<Authority> authority) {
        this.authorities = authority;
    }

    public List<Advt> getAdvts() {
        return advts;
    }

    public void setAdvts(List<Advt> advts) {
        this.advts = advts;
    }
}
