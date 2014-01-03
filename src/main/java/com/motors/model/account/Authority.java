package com.motors.model.account;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES", schema = "carservice")
public class Authority extends BaseEntity {
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

    @Column(name = "AUTHORITY")
    private String authority;

    @ManyToOne
    private User user;

    public Authority() {
        authority = ROLE_ANONYMOUS;
    }

    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
