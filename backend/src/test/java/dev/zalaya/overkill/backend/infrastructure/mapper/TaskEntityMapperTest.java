package dev.zalaya.overkill.backend.infrastructure.mapper;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskAssertions;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskEntityAssertions;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.mapper.TaskEntityMapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static dev.zalaya.overkill.backend.domain.model.TaskFixtures.aTaskWith;
import static dev.zalaya.overkill.backend.infrastructure.entity.TaskEntityFixtures.aTaskEntityWith;

class TaskEntityMapperTest {

    private final TaskEntityMapper mapper = Mappers.getMapper(TaskEntityMapper.class);

    @Test
    void givenTaskEntity_whenToDomain_thenReturnMappedTask() {
        // Given
        TaskEntity taskEntity = aTaskEntityWith("Title", Priority.HIGH);

        // When
        Task mappedTask = mapper.toDomain(taskEntity);

        // Then
        TaskAssertions.assertThat(mappedTask).hasSameFieldsAs(taskEntity);
    }

    @Test
    void givenTaskEntities_whenToDomain_thenReturnMappedTasks() {
        // Given
        TaskEntity taskEntity1 = aTaskEntityWith("Title 1", Priority.LOW);
        TaskEntity taskEntity2 = aTaskEntityWith("Title 2", Priority.HIGH);
        List<TaskEntity> taskEntities = List.of(taskEntity1, taskEntity2);

        // When
        List<Task> mappedTasks = mapper.toDomain(taskEntities);

        // Then
        TaskAssertions.assertThat(mappedTasks.get(0)).hasSameFieldsAs(taskEntity1);
        TaskAssertions.assertThat(mappedTasks.get(1)).hasSameFieldsAs(taskEntity2);
    }

    @Test
    void givenTask_whenToEntity_thenReturnMappedTaskEntity() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        // When
        TaskEntity mappedTaskEntity = mapper.toEntity(task);

        // Then
        TaskEntityAssertions.assertThat(mappedTaskEntity).hasSameFieldsAs(task);
    }

    @Test
    void givenTasks_whenToEntity_thenReturnMappedTaskEntities() {
        // Given
        Task task1 = aTaskWith("Title 1", Priority.HIGH);
        Task task2 = aTaskWith("Title 2", Priority.LOW);
        List<Task> tasks = List.of(task1, task2);

        // When
        List<TaskEntity> mappedTaskEntities = mapper.toEntity(tasks);

        // Then
        TaskEntityAssertions.assertThat(mappedTaskEntities.get(0)).hasSameFieldsAs(task1);
        TaskEntityAssertions.assertThat(mappedTaskEntities.get(1)).hasSameFieldsAs(task2);
    }

}
