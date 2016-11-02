package com.mycompany.app.service;

import com.mycompany.app.dto.Employee;
import com.mycompany.app.entity.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(long id);

    List<Employee> getEmployeeBySalary(int salary, int start, int pageSize);

    Long save(EmployeeEntity employeeEntity);

    Long merge(EmployeeEntity employeeEntity);
}
