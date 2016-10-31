package com.mycompany.app;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TestExecutionListeners({
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class
})
public class TestSelectEmployee {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void getByID() {
        Employee employee = employeeService.getEmployeeById(1);

        System.out.println(employee.toString());

    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
