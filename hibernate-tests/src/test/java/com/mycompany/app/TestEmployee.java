package com.mycompany.app;

import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.dto.Employee;
import com.mycompany.app.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestEmployee extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void testEmployeeSubselect() {
        List<Employee> employees = employeeService.getEmployeeBySalaryWithSubSelect(5500, 0, 500);
        System.out.println("FINISH");
    }
}
