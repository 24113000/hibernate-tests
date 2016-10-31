package com.mycompany.app.service.impl;

import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.entity.EmployeeEntity;
import com.mycompany.app.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Override
    public EmployeeEntity getEmployeeById(long id) {
        return employeeDAO.getById(id);
    }


    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
