package com.mycompany.app.converter;

import com.mycompany.app.dto.Skill;
import com.mycompany.app.entity.SkillEntity;

public class SkillConverter {
    private SkillConverter() {

    }

    public static Skill toSkillAllFields(SkillEntity entity) {
        if (entity == null) {
            return null;
        }
        Skill skill = new Skill();
        skill.setId(entity.getId());
        skill.setTitle(entity.getTitle());
        skill.setYears(entity.getYears());
        return skill;
    }
}
