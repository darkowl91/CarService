package com.motors.mvc.service;

import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.programm.nav.Page;

import java.util.List;

public interface IAdvertService {

    Advt getNewAdvtInstance(User user);

    void saveAdvt(Advt advt);

    void saveUpdateAdvt(Advt advt);

    Page getNextPage(int pageNumber, int pageSize);

    List<Advt> getAdvtToVerify();

    Advt getAdvtById(Long id);

    List<Advt> getAdvtToDelete();

    void deleteAdvt(Advt advt);

}
