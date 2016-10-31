package com.mycompany.app.dao.impl;

import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.entity.EmployeeEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class EmployeeDAOImpl extends BaseDAOImpl<EmployeeEntity, Long> implements EmployeeDAO {

    @Override
    public List<EmployeeEntity> getEmployeeBySalary(int salary, int offset, int pageSize) {
        Session session = getSession();
        Query query = session.createQuery(" from EmployeeEntity e where e.salary >=:salary  ")
                .setFirstResult(offset)
                .setMaxResults(pageSize);
        query.setParameter("salary", salary);
        //noinspection unchecked
        return query.list();
    }
}
