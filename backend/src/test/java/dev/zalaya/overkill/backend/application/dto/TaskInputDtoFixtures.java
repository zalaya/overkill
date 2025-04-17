package dev.zalaya.overkill.backend.application.dto;

import dev.zalaya.overkill.api.model.TaskInputDto;
import dev.zalaya.overkill.backend.domain.model.Priority;

import static dev.zalaya.overkill.api.model.TaskInputDto.PriorityEnum.fromValue;

public class TaskInputDtoFixtures {

    public static TaskInputDto aTaskInputDtoWith(String title, Priority priority) {
        return TaskInputDto.builder()
            .title(title)
            .priority(fromValue(priority.toString()))
            .build();
    }

}
