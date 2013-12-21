package com.motors.mvc.service;


import com.motors.dao.BaseEntityDao;
import com.motors.dao.IEntityDao;
import com.motors.model.account.Authorities;
import com.motors.model.account.Phone;
import com.motors.model.account.User;
import com.motors.model.account.UserPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IAccountService")
@Transactional
public class AccountService implements IAccountService {

    BaseEntityDao<User> userDao;
    IEntityDao<Phone> phoneDao;

    IEntityDao<UserPicture> userPictureDao;
    IEntityDao<Authorities> userAuthoritiesDao;

    @Autowired
    public void setUserDao(BaseEntityDao<User> userBaseEntityDao) {
        userDao = userBaseEntityDao;
        userDao.setClazz(User.class);
    }

    @Override
    public User getLoginPerson(String login) {
        User person = null;
        return person;

    }

}
