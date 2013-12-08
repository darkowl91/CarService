package com.motors.dao;

import com.motors.model.BaseEntity;

import java.util.List;

public interface IEntityDao<T extends BaseEntity> {

    List<T> getAll();

    T getById(Long id);

    void saveUpdate(T baseEntity);

    void remove(T baseEntity);

}
