package com.motors.mvc.service;

import com.motors.model.account.Authority;
import com.motors.model.account.User;

public interface IAccountService {

    User getLoginPerson(String login);

    User getNewUserInstance(Authority... authority);

    void saveUser(User user);
}
