package com.mycompany.app.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {
    T getById(ID id);

    List<T> getAll();

    List<T> getByIDs(List<ID> ids);

    T save(T entity);

    void delete(T entity);

    void delete(ID id);

    long count();

    void flush();

    void clear();
}
