package com.codequality.assembly.dao;

import java.util.List;

public interface BaseDao<T> {

    void insert(T t);

    void update(T t);

    void delete(T t);

    T get(Long id);

    List<T> list();

}
