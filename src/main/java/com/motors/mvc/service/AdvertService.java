package com.motors.mvc.service;

import com.motors.dao.BaseEntityDao;
import com.motors.model.account.User;
import com.motors.model.advertisement.Advt;
import com.motors.model.auto.Car;
import com.motors.model.auto.CarPicture;
import com.motors.programm.nav.Page;
import com.motors.programm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service("IAdvertService")
@Transactional
public class AdvertService implements IAdvertService {

    BaseEntityDao<Advt> advtDao;

    @Autowired
    public void setDao(BaseEntityDao<Advt> advtDao) {
        this.advtDao = advtDao;
        this.advtDao.setClazz(Advt.class);
    }

    @Override
    public Advt getNewAdvtInstance(User user) {
        Advt advt = new Advt();
        advt.setDate(DateUtil.getDateNow());
        Car car = new Car();
        car.setPictures(new HashSet<CarPicture>());
        advt.setCar(car);
        advt.setVerified(false);
        advt.setUser(user);
        return advt;
    }

    @Override
    public void saveAdvt(Advt advt) {
        advtDao.save(advt);
    }

    @Override
    public void saveUpdateAdvt(Advt advt) {
        advtDao.saveUpdate(advt);
    }

    @Override
    public Page getNextPage(int pageNumber, int pageSize){
        return advtDao.getPage(pageNumber, pageSize, "order by date asc");
    }

    @Override
    public List<Advt> search(Map<String, Object> searchParams) {

        StringBuilder hql = new StringBuilder(advtDao.getQueryPartFrom());
        hql.append("as advt");
        hql.append(" join FETCH advt.car as car");

        if(searchParams.get("body")!= null){
            hql.append(" join FETCH car.body as bodyType");
        }
        if(searchParams.get("model")!=null || searchParams.get("brand")!=null ){
        hql.append(" join FETCH car.model as carModel");
        }
        if(searchParams.get("brand")!=null){
            hql.append(" join FETCH carModel.brand as carBrand");
        }
        hql.append(" Where 1=1");
        hql.append(" and advt.verified=:verified");
        hql.append(" and car.price>=:price_from");
        hql.append(" and car.price<:price_to");
        hql.append(" and car.produceYear=:year");
        if(searchParams.get("transmission")!=null){
            hql.append(" and car.transmission=:transmission");
        }
        if(searchParams.get("body")!= null){
            hql.append(" and bodyType.id=:body");
        }
        if(searchParams.get("model")!=null){
        hql.append(" and carModel.id=:model");
        }
        if(searchParams.get("brand")!=null){
        hql.append(" and carBrand.id=:brand");
        }

        searchParams.put("verified", true);
        advtDao.getByNamedQuery(hql.toString(), searchParams);

        return advtDao.getByNamedQuery(hql.toString(), searchParams);
    }

    public List<Advt> getAdvtToVerify() {
        return advtDao.getByNamedQuery(advtDao.getQueryPartFrom() + "WHERE " + "verified=:verified", false);
    }

    @Override
    public Advt getAdvtById(Long id) {
        return advtDao.getById(id);
    }

    @Override
    public  List<Advt> getAdvtToDelete(){
        return advtDao.getByNamedQuery(advtDao.getQueryPartFrom() + "WHERE " + "verified=:verified", true);
    }

    @Override
    public void deleteAdvt(Advt advt){
        advtDao.remove(advt);
    }
}
