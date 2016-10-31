package com.mycompany.app.dao;

import com.mycompany.app.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO extends BaseDAO<EmployeeEntity, Long> {

    List<EmployeeEntity> getEmployeeBySalary(int salary, int offset, int pageSize);
}
