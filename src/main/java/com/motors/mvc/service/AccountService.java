package com.motors.mvc.service;


import com.motors.dao.BaseEntityDao;
import com.motors.model.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
       // Map<String, Object> parameters = new HashMap<String, Object>();
       // parameters.put("login", login);
        List<User> users = userDao.getByNamedQuery("FROM User WHERE username=:login", login);
        return users.get(0);
    }

}
