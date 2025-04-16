package dev.zalaya.overkill.backend.infrastructure.persistence.adapter;

import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.domain.port.outbound.TaskRepository;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;
import dev.zalaya.overkill.backend.infrastructure.persistence.mapper.TaskEntityMapper;
import dev.zalaya.overkill.backend.infrastructure.persistence.repository.TaskJpaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepository {

    private final TaskJpaRepository repository;
    private final TaskEntityMapper mapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = mapper.toEntity(task);
        TaskEntity persistedTaskEntity = repository.save(taskEntity);

        return mapper.toDomain(persistedTaskEntity);
    }

    @Override
    public List<Task> saveAll(List<Task> tasks) {
        List<TaskEntity> taskEntities = mapper.toEntity(tasks);
        List<TaskEntity> persistedTaskEntities = repository.saveAll(taskEntities);

        return mapper.toDomain(persistedTaskEntities);
    }

}
