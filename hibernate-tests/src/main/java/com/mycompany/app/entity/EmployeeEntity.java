package com.mycompany.app.entity;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq")
    @Column(name = "id_employee")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private int experience = 1;

    @Column(name = "salary")
    private Integer salary;

    @OneToMany(mappedBy = "employee")
    @BatchSize(size = 6)
    private List<TaskEntity> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @BatchSize(size = 6)
    private List<SkillEntity> skills = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @Fetch(FetchMode.SUBSELECT)//Bug! it will sub select all records without paging
    private List<SkillEntity> skillsSubselect = new ArrayList<>();

    public List<TaskEntity> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<SkillEntity> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public void addTask(TaskEntity taskEntity) {
        tasks.add(taskEntity);
        taskEntity.setEmployee(this);
    }

    public void removeTask(TaskEntity taskEntity) {
        tasks.remove(taskEntity);
        taskEntity.setEmployee(null);
    }

    public void addSkill(SkillEntity skill) {
        skills.add(skill);
        skill.setEmployee(this);
    }

    public void removeSkill(SkillEntity skillEntity) {
        skills.remove(skillEntity);
        skillEntity.setEmployee(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public void setSkills(List<SkillEntity> skills) {
        this.skills = skills;
    }

    public List<SkillEntity> getSkillsSubselect() {
        return skillsSubselect;
    }

    public void setSkillsSubselect(List<SkillEntity> skillsSubselect) {
        this.skillsSubselect = skillsSubselect;
    }
}
