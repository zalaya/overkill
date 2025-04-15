package dev.zalaya.overkill.backend.infrastructure.entity;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;

public class TaskEntityFixtures {

    public static TaskEntity aTaskEntityWith(String title, Priority priority) {
        return TaskEntity.builder()
            .title(title)
            .priority(priority)
            .build();
    }

}
