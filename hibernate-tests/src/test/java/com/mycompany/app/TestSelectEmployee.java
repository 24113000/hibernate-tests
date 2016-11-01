package com.mycompany.app;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.mycompany.app.datasource.sql.QueryCountInfo;
import com.mycompany.app.datasource.sql.QueryCountInfoHolder;
import com.mycompany.app.dto.Employee;
import com.mycompany.app.dto.Skill;
import com.mycompany.app.entity.EmployeeEntity;
import com.mycompany.app.entity.SkillEntity;
import com.mycompany.app.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

public class TestSelectEmployee extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void getByID() {
        Employee employee = employeeService.getEmployeeById(1);

        System.out.println(employee.toString());
    }

    @Test
    public void getBySalaryPaging() {
        List<Employee> employeesBySalary = employeeService.getEmployeeBySalary(5500, 10, 130);
        employeesBySalary.forEach(System.out::println);
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
