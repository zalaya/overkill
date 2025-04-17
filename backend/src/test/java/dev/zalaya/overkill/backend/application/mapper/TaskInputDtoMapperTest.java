package dev.zalaya.overkill.backend.application.mapper;

import dev.zalaya.overkill.api.model.TaskInputDto;
import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskAssertions;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskInputDtoAssertions;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static dev.zalaya.overkill.backend.application.dto.TaskInputDtoFixtures.aTaskInputDtoWith;
import static dev.zalaya.overkill.backend.domain.model.TaskFixtures.aTaskWith;

class TaskInputDtoMapperTest {

    private final TaskInputDtoMapper mapper = Mappers.getMapper(TaskInputDtoMapper.class);

    @Test
    void givenTaskInputDto_whenToDomain_thenReturnMappedTask() {
        // Given
        TaskInputDto taskInputDto = aTaskInputDtoWith("Title", Priority.HIGH);

        // When
        Task mappedTask = mapper.toDomain(taskInputDto);

        // Then
        TaskAssertions.assertThat(mappedTask).hasSameFieldsAs(taskInputDto);
    }

    @Test
    void givenTaskEntities_whenToDomain_thenReturnMappedTasks() {
        // Given
        TaskInputDto taskInputDto1 = aTaskInputDtoWith("Title 1", Priority.LOW);
        TaskInputDto taskInputDto2 = aTaskInputDtoWith("Title 2", Priority.HIGH);
        List<TaskInputDto> taskInputDtos = List.of(taskInputDto1, taskInputDto2);

        // When
        List<Task> mappedTasks = mapper.toDomain(taskInputDtos);

        // Then
        TaskAssertions.assertThat(mappedTasks.get(0)).hasSameFieldsAs(taskInputDto1);
        TaskAssertions.assertThat(mappedTasks.get(1)).hasSameFieldsAs(taskInputDto2);
    }

    @Test
    void givenTask_whenToEntity_thenReturnMappedTaskEntity() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        // When
        TaskInputDto mappedTaskInputDto = mapper.toDto(task);

        // Then
        TaskInputDtoAssertions.assertThat(mappedTaskInputDto).hasSameFieldsAs(task);
    }

    @Test
    void givenTasks_whenToEntity_thenReturnMappedTaskEntities() {
        // Given
        Task task1 = aTaskWith("Title 1", Priority.HIGH);
        Task task2 = aTaskWith("Title 2", Priority.LOW);
        List<Task> tasks = List.of(task1, task2);

        // When
        List<TaskInputDto> mappedTaskInputDtos = mapper.toDto(tasks);

        // Then
        TaskInputDtoAssertions.assertThat(mappedTaskInputDtos.get(0)).hasSameFieldsAs(task1);
        TaskInputDtoAssertions.assertThat(mappedTaskInputDtos.get(1)).hasSameFieldsAs(task2);
    }

}
