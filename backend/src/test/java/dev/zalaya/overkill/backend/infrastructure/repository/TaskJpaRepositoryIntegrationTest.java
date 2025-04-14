package dev.zalaya.overkill.backend.infrastructure.repository;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.repository.TaskJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskJpaRepositoryIntegrationTest {

    @Autowired
    private TaskJpaRepository repository;

    @Test
    void givenTaskEntity_whenSave_thenReturnPersistedTaskEntity() {
        // Given
        TaskEntity taskEntity = createTaskEntity("Title", Priority.MEDIUM);

        // When
        TaskEntity persistedTaskEntity = repository.save(taskEntity);

        // Then
        assertThat(persistedTaskEntity).isNotNull();
        assertPersistedTaskEntity(taskEntity, persistedTaskEntity);
    }

    @Test
    void givenTaskEntities_whenSaveAll_thenReturnPersistedTaskEntities() {
        // Given
        TaskEntity taskEntity1 = createTaskEntity("Title 1", Priority.LOW);
        TaskEntity taskEntity2 = createTaskEntity("Title 2", Priority.HIGH);
        List<TaskEntity> taskEntities = List.of(taskEntity1, taskEntity2);

        // When
        List<TaskEntity> persistedTaskEntities = repository.saveAll(taskEntities);

        // Then
        assertThat(persistedTaskEntities).isNotNull().hasSize(2);
        assertPersistedTaskEntity(taskEntity1, persistedTaskEntities.get(0));
        assertPersistedTaskEntity(taskEntity2, persistedTaskEntities.get(1));
    }

    private TaskEntity createTaskEntity(String title, Priority priority) {
        return TaskEntity.builder()
            .title(title)
            .priority(priority)
            .build();
    }

    private void assertPersistedTaskEntity(TaskEntity expected, TaskEntity actual) {
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getPriority()).isEqualTo(expected.getPriority());
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getCreatedAt()).isNotNull();
        assertThat(actual.getUpdatedAt()).isNotNull();
    }

}
