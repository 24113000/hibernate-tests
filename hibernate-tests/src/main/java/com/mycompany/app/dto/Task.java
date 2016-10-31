package com.mycompany.app.dto;

import java.util.Date;

/**
 * Created by Igor Dmitriev on 9/21/16
 */
public class Task {
    private Long id;
    private int estimate;
    private String description;
    private Date createDate;
    private Date modifyDate;
    private boolean highPriority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isHighPriority() {
        return highPriority;
    }

    public void setHighPriority(boolean highPriority) {
        this.highPriority = highPriority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", estimate=" + estimate +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", highPriority=" + highPriority +
                '}';
    }
}
