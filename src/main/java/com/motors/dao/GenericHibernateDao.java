package com.motors.dao;

import com.motors.model.BaseEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T extends BaseEntity>
        extends BaseEntityDao<T> implements IEntityDao<T> {
    //the generic DAO implementation will become the only implementation needed:
    // First, note that the generic implementation is itself parametrized – allowing the client to choose
    // the correct parameter in a case by case basis.
    // This will mean that the clients gets all the benefits of type safety
    // without needing to create multiple artifacts for each entity.
}
