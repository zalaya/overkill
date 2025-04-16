package dev.zalaya.overkill.backend.infrastructure.persistence.mapper;

import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskEntityMapper {

    Task toDomain(TaskEntity taskEntity);
    List<Task> toDomain(List<TaskEntity> taskEntities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TaskEntity toEntity(Task task);
    List<TaskEntity> toEntity(List<Task> tasks);

}
