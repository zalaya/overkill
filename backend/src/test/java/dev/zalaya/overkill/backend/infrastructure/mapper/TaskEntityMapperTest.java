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
        assertThat(mappedTask).isNotNull();
        assertThat(mappedTask.getTitle()).isEqualTo(taskEntity.getTitle());
        assertThat(mappedTask.getDescription()).isEqualTo(taskEntity.getDescription());
        assertThat(mappedTask.getPriority()).isEqualTo(taskEntity.getPriority());
        assertThat(mappedTask.getExpiresAt()).isEqualTo(taskEntity.getExpiresAt());
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
        assertThat(mappedTasks).hasSize(2);
        assertThat(mappedTasks.get(0).getTitle()).isEqualTo(taskEntity1.getTitle());
        assertThat(mappedTasks.get(1).getTitle()).isEqualTo(taskEntity2.getTitle());
    }

    @Test
    void givenTask_whenToEntity_thenMapsAllFields() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        // When
        TaskEntity mappedTaskEntity = mapper.toEntity(task);

        // Then
        assertThat(mappedTaskEntity.getId()).isNull();
        assertThat(mappedTaskEntity.getCreatedAt()).isNull();
        assertThat(mappedTaskEntity.getUpdatedAt()).isNull();
        assertThat(mappedTaskEntity.getTitle()).isEqualTo(task.getTitle());
        assertThat(mappedTaskEntity.getDescription()).isEqualTo(task.getDescription());
        assertThat(mappedTaskEntity.getPriority()).isEqualTo(task.getPriority());
        assertThat(mappedTaskEntity.getExpiresAt()).isEqualTo(task.getExpiresAt());
    }

    @Test
    void givenTasks_whenToEntity_thenMapsEachCorrectly() {
        Task task1 = aTaskWith("Title 1", Priority.HIGH);
        Task task2 = aTaskWith("Title 2", Priority.LOW);
        List<Task> tasks = List.of(task1, task2);

        // When
        List<TaskEntity> mappedTaskEntities = mapper.toEntity(tasks);

        // Then
        assertThat(mappedTaskEntities).hasSize(2);
        assertThat(mappedTaskEntities.get(0).getTitle()).isEqualTo(task1.getTitle());
        assertThat(mappedTaskEntities.get(1).getTitle()).isEqualTo(task2.getTitle());
    }

}
