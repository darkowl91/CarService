package com.motors.dao;

import com.motors.model.BaseEntity;
import com.motors.programm.nav.Page;
import com.motors.programm.nav.PageImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class BaseEntityDao<T extends BaseEntity> implements IEntityDao<T> {

    @Autowired
    org.hibernate.SessionFactory sessionFactory;

    private Class<T> clazz;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createQuery(getQueryPartFrom()).list();
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
    public void save(T baseEntity) {
        getCurrentSession().save(baseEntity);
    }

    @Override
    public void remove(T baseEntity) {
        getCurrentSession().delete(baseEntity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getByNamedQuery(String queryText, Map<String, Object> parameters) {
        Query query = getCurrentSession().createQuery(queryText);
        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
        return query.list();
    }

    @Override
    public List<T> getByNamedQuery(String queryText, Object... parameters) {
        Query query = getCurrentSession().createQuery(queryText);
        String[] namedParameters = query.getNamedParameters();
        if (namedParameters.length != parameters.length) {
            return Collections.emptyList();
        }

        for (int i = 0, namedParametersLength = namedParameters.length; i < namedParametersLength; i++) {
            String namedParameter = namedParameters[i];
            query.setParameter(namedParameter, parameters[i]);
        }
        return query.list();
    }

    @Override
    public long getCount() {
        return (Long) getCurrentSession().createQuery("Select Count(*) " + getQueryPartFrom()).uniqueResult();
    }

    @Override
    public Page<T> getPage(int pageNumber, int pageSize, String orderBy) {
        long totalNumber = getCount();
        Query query = getCurrentSession().createQuery(getQueryPartFrom() + orderBy);
        query.setParameter("verified", true);
        int firstResult = (pageNumber - 1) * pageSize;
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        List<T> list = query.list();
        Page<T> page = new PageImpl<T>(list, pageNumber, pageSize, totalNumber);
        return page;
    }

    public String getQueryPartFrom() {
        return "FROM " + clazz.getName() + " ";
    }
}
