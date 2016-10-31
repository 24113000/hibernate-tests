package com.mycompany.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
    @SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq")
    @Column(name = "id_skill")
    private Long id;

    @Column(name = "title")
    @NotNull
    @Enumerated(EnumType.STRING)
    private SkillTitle title;

    @Column(name = "years")
    private int years = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    @NotNull
    private EmployeeEntity employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillTitle getTitle() {
        return title;
    }

    public void setTitle(SkillTitle title) {
        this.title = title;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }
}
