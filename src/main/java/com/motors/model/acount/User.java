package com.motors.model.acount;

import com.motors.model.BaseEntity;

import java.sql.Date;
import java.util.List;

public class User extends BaseEntity {
    private String username;
    private String pasword;
    private boolean enabled;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private Date registrationDate;
    private List<Phone> phones;
    private Authorities authority;
}
