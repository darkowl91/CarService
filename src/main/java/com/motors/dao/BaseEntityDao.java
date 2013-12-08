package com.motors.dao;

import com.motors.model.BaseEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseEntityDao<T extends BaseEntity> implements IEntityDao<T> {

    @Autowired
    org.hibernate.SessionFactory sessionFactory;

    private Class<T> clazz;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createQuery("from" + clazz.getName()).list();
    }

    @Override
    public T getById(Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public void saveUpdate(T baseEntity) {
        getCurrentSession().saveOrUpdate(baseEntity);
    }

    @Override
    public void remove(T baseEntity) {
        getCurrentSession().delete(baseEntity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
