package dev.zalaya.overkill.backend.infrastructure.adapter;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.persistence.adapter.TaskRepositoryAdapter;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.mapper.TaskEntityMapper;
import dev.zalaya.overkill.backend.infrastructure.persistence.repository.TaskJpaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static dev.zalaya.overkill.backend.fixtures.TaskFixtures.aTaskWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskRepositoryAdapterTest {

    @Mock
    private TaskJpaRepository repository;

    @Mock
    private TaskEntityMapper mapper;

    @InjectMocks
    private TaskRepositoryAdapter adapter;

    @Test
    void givenTask_whenSave_thenCallCorrectMethods() {
        // Given
        Task task = aTaskWith("Title", Priority.HIGH);

        when(repository.save(any())).thenReturn(new TaskEntity());

        // When
        adapter.save(task);

        // Then
        verify(mapper).toEntity(any(Task.class));
        verify(repository).save(any());
        verify(mapper).toDomain(any(TaskEntity.class));
    }

    @Test
    void givenTasks_whenSaveAll_thenCallCorrectMethods() {
        // Given
        Task task1 = aTaskWith("Title 1", Priority.HIGH);
        Task task2 = aTaskWith("Title 2", Priority.LOW);
        List<Task> tasks = List.of(task1, task2);

        when(repository.saveAll(any())).thenReturn(List.of(new TaskEntity()));

        // When
        adapter.saveAll(tasks);

        // Then
        verify(mapper).toEntity(anyList());
        verify(repository).saveAll(any());
        verify(mapper).toDomain(anyList());
    }

}
