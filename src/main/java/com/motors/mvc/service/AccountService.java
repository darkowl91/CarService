package com.motors.mvc.service;


import com.motors.dao.BaseEntityDao;
import com.motors.model.account.Authority;
import com.motors.model.account.Phone;
import com.motors.model.account.User;
import com.motors.model.account.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("IAccountService")
@Transactional
public class AccountService implements IAccountService {

    BaseEntityDao<User> userDao;

    @Autowired
    public void setUserDao(BaseEntityDao<User> userBaseEntityDao) {
        userDao = userBaseEntityDao;
        userDao.setClazz(User.class);
    }

    @Override
    public User getLoginPerson(String login) {
        List<User> users = userDao.getByNamedQuery("FROM User WHERE username=:login", login);
        return users.get(0);
    }

    @Override
    public User getNewUserInstance(String roleName) {
        User user = new User();
        user.setPicture(new UserPicture());
        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new Authority(roleName, user));
        user.setAuthority(authorities);
        List<Phone> phoneList = new ArrayList<Phone>();
        user.setPhones(phoneList);
        user.setEnabled(true);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUpdate(user);
    }
}
