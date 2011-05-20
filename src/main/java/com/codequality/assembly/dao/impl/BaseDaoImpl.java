package com.codequality.assembly.dao.impl;

import com.codequality.assembly.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    protected final Session getSession(){
        return SessionFactoryUtils.getSession(sessionFactory, true);
    }

    @SuppressWarnings({"unchecked"})
    public BaseDaoImpl(){
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void insert(T t) {
        getSession().save(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public T get(Long id) {
        return (T) getSession().get(entityClass, id);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public List<T> list() {
        return getSession().createQuery("from " +  entityClass.getName()).list();
    }

    protected Query createQuery(String hql){
        return getSession().createQuery(hql);
    }
}
