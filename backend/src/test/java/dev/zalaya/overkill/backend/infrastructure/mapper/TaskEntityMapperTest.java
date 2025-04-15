package dev.zalaya.overkill.backend.infrastructure.mapper;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskAssertions;
import dev.zalaya.overkill.backend.infrastructure.assertions.TaskEntityAssertions;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.mapper.TaskEntityMapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class TaskEntityMapperTest {

    private final TaskEntityMapper mapper = Mappers.getMapper(TaskEntityMapper.class);

    @Test
    void givenTaskEntity_whenToDomain_thenReturnTask() {
        // Given
        TaskEntity taskEntity = aTaskEntityWith("Title", Priority.HIGH);

        // When
        Task mappedTask = mapper.toDomain(taskEntity);

        // Then
        assertMappingOf(mappedTask, taskEntity);
    }

    @Test
    void givenTask_whenToEntity_thenReturnTaskEntity() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        // When
        TaskEntity mappedTaskEntity = mapper.toEntity(task);

        // Then
        assertMappingOf(mappedTaskEntity, task);
    }

    private TaskEntity aTaskEntityWith(String title, Priority priority) {
        return TaskEntity.builder()
            .title(title)
            .priority(priority)
            .build();
    }

    private Task aTaskWith(String title, Priority priority) {
        return Task.builder()
            .title(title)
            .priority(priority)
            .build();
    }

    private void assertMappingOf(Task expected, TaskEntity actual) {
        TaskAssertions.assertThat(expected)
            .hasSameFieldsAs(actual);
    }

    private void assertMappingOf(TaskEntity expected, Task actual) {
        TaskEntityAssertions.assertThat(expected)
            .hasSameFieldsAs(actual);
    }

}
