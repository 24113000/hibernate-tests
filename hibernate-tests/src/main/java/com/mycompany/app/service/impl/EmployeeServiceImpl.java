package com.mycompany.app.service.impl;

import com.mycompany.app.converter.EmployeeConverter;
import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.dto.Employee;
import com.mycompany.app.entity.EmployeeEntity;
import com.mycompany.app.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Override
    public Employee getEmployeeById(long id) {
        return EmployeeConverter.toEmployeeAllFields(employeeDAO.getById(id));
    }

    @Override
    public List<Employee> getEmployeeBySalary(int salary, int start, int pageSize) {
        List<EmployeeEntity> entityList = employeeDAO.getEmployeeBySalary(salary, start, pageSize);
        List<Employee> employeeList = new ArrayList<>(entityList.size());
        for (EmployeeEntity employeeEntity : entityList) {
            employeeList.add(EmployeeConverter.toEmployeeAllFields(employeeEntity));
        }
        return employeeList;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
