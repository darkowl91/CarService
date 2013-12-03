package com.motors.model.acount;

import com.motors.model.BaseEntity;

import java.util.List;

public class Authorities extends BaseEntity {
    private String authority;
    private List<User> users;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
