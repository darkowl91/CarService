package com.motors.mvc.service;

import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.programm.nav.Page;

public interface IAdvertService {

    Advt getNewAdvtInstance(User user);

    void saveAdvt(Advt advt);

    Page getNextPage(int pageNumber, int pageSize);

}
