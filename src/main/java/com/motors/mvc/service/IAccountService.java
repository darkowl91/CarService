package com.motors.mvc.service;

import com.motors.model.account.User;

public interface IAccountService {

    User getLoginPerson(String login);

    User getNewUserInstance(String roleName);

    void saveUser(User user);
}
