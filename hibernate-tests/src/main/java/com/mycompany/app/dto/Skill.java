package com.mycompany.app.dto;

import com.mycompany.app.entity.SkillTitle;

/**
 * Created by Igor Dmitriev on 9/21/16
 */
public class Skill {
    private Long id;
    private double years;
    private SkillTitle title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public SkillTitle getTitle() {
        return title;
    }

    public void setTitle(SkillTitle title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", years=" + years +
                ", title=" + title +
                ", description='" + description + '\'' +
                '}';
    }
}
