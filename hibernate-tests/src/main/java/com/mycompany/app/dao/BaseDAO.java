package com.mycompany.app.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {
    T getById(ID id);

    T loadById(ID id);

    T merge(T entity);

    void update(T entity);

    void persist(T entity);

    List<T> getAll();

    List<T> getByIDs(List<ID> ids);

    Long save(T entity);

    void delete(T entity);

    void delete(ID id);

    long count();

    void flush();

    void clear();
}
