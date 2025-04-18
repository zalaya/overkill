package dev.zalaya.overkill.backend.infrastructure.mapper;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.mapper.TaskEntityMapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static dev.zalaya.overkill.backend.fixtures.TaskFixtures.aTaskWith;
import static dev.zalaya.overkill.backend.fixtures.TaskEntityFixtures.aTaskEntityWith;
import static org.assertj.core.api.Assertions.assertThat;

class TaskEntityMapperTest {

    private final TaskEntityMapper mapper = Mappers.getMapper(TaskEntityMapper.class);

    @Test
    void givenTaskEntity_whenToDomain_thenMapsAllFields() {
        // Given
        TaskEntity taskEntity = aTaskEntityWith("Title", Priority.HIGH);

        // When
        Task mappedTask = mapper.toDomain(taskEntity);

        // Then
        assertMappingOf(taskEntity, mappedTask);
    }

    @Test
    void givenTaskEntities_whenToDomain_thenMapsEachCorrectly() {
        // Given
        TaskEntity taskEntity1 = aTaskEntityWith("Title 1", Priority.LOW);
        TaskEntity taskEntity2 = aTaskEntityWith("Title 2", Priority.HIGH);
        List<TaskEntity> taskEntities = List.of(taskEntity1, taskEntity2);

        // When
        List<Task> mappedTasks = mapper.toDomain(taskEntities);

        // Then
        assertMappingOf(taskEntity1, mappedTasks.get(0));
        assertMappingOf(taskEntity2, mappedTasks.get(1));
    }

    @Test
    void givenTask_whenToEntity_thenMapsAllFields() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        // When
        TaskEntity mappedTaskEntity = mapper.toEntity(task);

        // Then
        assertMappingOf(mappedTaskEntity, task);
    }

    @Test
    void givenTasks_whenToEntity_thenMapsEachCorrectly() {
        Task task1 = aTaskWith("Title 1", Priority.HIGH);
        Task task2 = aTaskWith("Title 2", Priority.LOW);
        List<Task> tasks = List.of(task1, task2);

        // When
        List<TaskEntity> mappedTaskEntities = mapper.toEntity(tasks);

        // Then
        assertMappingOf(mappedTaskEntities.get(0), task1);
        assertMappingOf(mappedTaskEntities.get(1), task2);
    }

    private void assertMappingOf(TaskEntity expected, Task actual) {
        assertThat(expected)
            .usingRecursiveComparison()
            .ignoringFields("id", "createdAt", "updatedAt")
            .isEqualTo(actual);
    }

}
