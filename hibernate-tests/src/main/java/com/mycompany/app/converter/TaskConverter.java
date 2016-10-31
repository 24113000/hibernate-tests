package com.mycompany.app.converter;


import com.mycompany.app.dto.Task;
import com.mycompany.app.entity.TaskEntity;

/**
 * Created by Igor Dmitriev on 10/6/16
 */
public class TaskConverter {
    private TaskConverter() {

    }

    public static Task toTaskAllFields(TaskEntity entity) {
        if (entity == null) {
            return null;
        }
        Task task = new Task();
        task.setId(entity.getId());
        task.setDescription(entity.getDescription());
        task.setCreateDate(entity.getCreateDate());
        task.setEstimate(entity.getEstimate());
        task.setModifyDate(entity.getModifyDate());
        task.setHighPriority(entity.isHighPriority());
        return task;
    }
}
