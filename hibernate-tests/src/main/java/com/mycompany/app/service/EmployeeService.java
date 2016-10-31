package com.mycompany.app.service;

import com.mycompany.app.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(long id);

    List<Employee> getEmployeeBySalary(int salary, int start, int pageSize);
}
