package com.mycompany.app.dao.impl;

import com.mycompany.app.dao.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseDAOImpl<T, ID extends Serializable> implements BaseDAO<T, ID> {

    private final Class<T> entityClass;
    private final Class<ID> classId;
    private SessionFactory sessionFactory;

    public BaseDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] args = genericSuperclass.getActualTypeArguments();
        //noinspection unchecked
        this.entityClass = (Class<T>) args[0];
        //noinspection unchecked
        this.classId = (Class<ID>) args[1];
    }

    @Override
    public T getById(ID id) {
        Session session = getSession();
        //noinspection unchecked
        return (T) session.get(entityClass, id);
    }

    @Override
    public T loadById(ID id) {
        Session session = getSession();
        //noinspection unchecked
        return (T) session.load(entityClass, id);
    }

    @Override
    @Transactional(readOnly = false)
    public T merge(T entity) {
        Session session = getSession();
        //noinspection unchecked
        return (T) session.merge(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        Session session = getSession();
        session.update(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void persist(T entity) {
        Session session = getSession();
        session.persist(entity);
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(entityClass);
        //noinspection unchecked
        return criteria.list();
    }

    @Override
    public List<T> getByIDs(List<ID> ids) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.in("id", ids));
        //noinspection unchecked
        return criteria.list();
    }

    @Transactional(readOnly = false)
    @Override
    public Long save(T entity) {
        Session session = getSession();
        Serializable saved = session.save(entity);
        //noinspection unchecked
        return (Long) saved;
    }

    @Override
    public void delete(T entity) {
        Session session = getSession();
        session.delete(entity);
    }

    @Override
    public void delete(ID id) {
        Session session = getSession();
        T entity = getById(id);
        session.delete(entity);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void flush() {
        Session session = getSession();
        session.flush();
    }

    @Override
    public void clear() {
        Session session = getSession();
        session.clear();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
