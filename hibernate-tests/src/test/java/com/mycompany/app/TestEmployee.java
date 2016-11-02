package com.mycompany.app;

import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.datasource.sql.QueryCountInfo;
import com.mycompany.app.datasource.sql.QueryCountInfoHolder;
import com.mycompany.app.dto.Employee;
import com.mycompany.app.entity.EmployeeEntity;
import com.mycompany.app.service.EmployeeService;
import org.hibernate.TransientObjectException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class TestEmployee extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDAO employeeDAO;

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

    @Test
    public void testMerge_if_object_dont_exitst(){
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setSalary(10000);
        newEmployee.setName("TestMerge");
        newEmployee.setExperience(20);
        EmployeeEntity merged = employeeDAO.merge(newEmployee);
        assertNotNull(merged.getId());

        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        assertEquals(1, queryInfo.countInserts());
        assertEquals(0, queryInfo.countSelect());//object doesn't have id it is means that object is new

        System.out.println("End method");
    }

    @Test
    public void testMerge_existed_object() {
        EmployeeEntity employee = employeeDAO.getById(1L);
        Random random = new Random();
        int salary = random.nextInt();
        employee.setSalary(salary);
        EmployeeEntity merged = employeeDAO.merge(employee);

        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        assertEquals(0, queryInfo.countInserts());
        assertEquals(2, queryInfo.countSelect());
        assertEquals(1, queryInfo.countUpdate());

        employee = employeeDAO.getById(1L);
        employee.setSalary(salary);
        merged = employeeDAO.merge(employee);

        assertEquals(0, queryInfo.countInserts());
        assertEquals(4, queryInfo.countSelect());//it checks that data not changed
        assertEquals(1, queryInfo.countUpdate());

        System.out.println("End method");
    }

    @Test
    public void testSave_new_object(){
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setSalary(10000);
        newEmployee.setName("TestSave");
        newEmployee.setExperience(20);
        Long savedId = employeeDAO.save(newEmployee);
        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        assertEquals(1, queryInfo.countInserts());
    }

    @Test
    public void testSave_existed_object(){
        EmployeeEntity employee = employeeDAO.getById(1L);
        Long savedId = employeeDAO.save(employee);
        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        //assertEquals(1, queryInfo.countUpdate());
        assertEquals(3, queryInfo.countSelect());//TODO #Q why does it select third time?
    }

    @Test(expected = TransientObjectException.class)
    public void testUpdate_new_object() {
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setSalary(10000);
        newEmployee.setName("TestMerge");
        newEmployee.setExperience(20);
        employeeDAO.update(newEmployee);
    }

    @Test
    public void testUpdate_existed_object(){
        EmployeeEntity employee = employeeDAO.getById(1L);
        employeeDAO.update(employee);
        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        assertEquals(1, queryInfo.countUpdate());
    }
}
