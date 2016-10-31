package com.mycompany.app.converter;

import com.mycompany.app.dto.Employee;
import com.mycompany.app.entity.EmployeeEntity;

import static java.util.stream.Collectors.toList;

public class EmployeeConverter {
    private EmployeeConverter() {

    }

    public static Employee toEmployee(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(entity.getId());
        employee.setName(entity.getName());
        employee.setExperience(entity.getExperience());
        employee.setSalary(entity.getSalary());
        return employee;
    }

    public static Employee toEmployeeWithTasks(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }
        Employee employee = toEmployee(entity);
        employee.setTasks(entity.getTasks().stream().map(TaskConverter::toTaskAllFields).collect(toList()));
        return employee;
    }

    public static Employee toEmployeeAllFields(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }
        Employee employee = toEmployee(entity);
        employee.setSkills(entity.getSkills().stream()
                .map(SkillConverter::toSkillAllFields).collect(toList()));
        employee.setTasks(entity.getTasks()
                .stream().map(TaskConverter::toTaskAllFields).collect(toList()));
        return employee;
    }

}
