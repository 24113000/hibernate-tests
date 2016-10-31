package com.mycompany.app.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
    @Column(name = "id_task")
    private Long id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "estimate")
    private Integer estimate;

    @Column(name = "high_priority")
    private boolean highPriority;

    @Column(name = "create_date")
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private Date createDate;

    @Column(name = "modify_date")
    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    private Date modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    @Getter(AccessLevel.NONE)
    private EmployeeEntity employee;

    @Column(name = "id_employee", updatable = false, insertable = false)
    private Long employeeId;

    public TaskEntity(String description) {
        this.description = description;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public boolean isHighPriority() {
        return highPriority;
    }

    public void setHighPriority(boolean highPriority) {
        this.highPriority = highPriority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}

