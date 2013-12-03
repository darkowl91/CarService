package com.motors.model.acount;

import com.motors.model.BaseEntity;

import java.util.List;

public class Authorities extends BaseEntity {
    private String authority;
    private List<User> users;
}
