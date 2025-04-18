package dev.zalaya.overkill.backend.infrastructure.repository;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.repository.TaskJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static dev.zalaya.overkill.backend.fixtures.TaskEntityFixtures.aTaskEntityWith;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskJpaRepositoryIntegrationTest {

    @Autowired
    private TaskJpaRepository repository;

    @Test
    void givenTaskEntity_whenSave_thenReturnPersistedTaskEntity() {
        // Given
        TaskEntity taskEntity = aTaskEntityWith("Title", Priority.MEDIUM);

        // When
        TaskEntity persistedTaskEntity = repository.save(taskEntity);

        // Then
        assertPersistenceOf(taskEntity, persistedTaskEntity);
    }

    @Test
    void givenTaskEntities_whenSaveAll_thenReturnPersistedTaskEntities() {
        // Given
        TaskEntity taskEntity1 = aTaskEntityWith("Title 1", Priority.LOW);
        TaskEntity taskEntity2 = aTaskEntityWith("Title 2", Priority.HIGH);
        List<TaskEntity> taskEntities = List.of(taskEntity1, taskEntity2);

        // When
        List<TaskEntity> persistedTaskEntities = repository.saveAll(taskEntities);

        // Then
        assertPersistenceOf(taskEntity1, persistedTaskEntities.get(0));
        assertPersistenceOf(taskEntity2, persistedTaskEntities.get(1));
    }

    private void assertPersistenceOf(TaskEntity expected, TaskEntity actual) {
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getCreatedAt()).isNotNull();
        assertThat(actual.getUpdatedAt()).isNotNull();
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        assertThat(actual.getPriority()).isEqualTo(expected.getPriority());
        assertThat(actual.getExpiresAt()).isEqualTo(expected.getExpiresAt());
    }

}
