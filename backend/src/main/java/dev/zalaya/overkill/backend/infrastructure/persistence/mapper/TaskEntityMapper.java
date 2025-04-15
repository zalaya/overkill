package dev.zalaya.overkill.backend.infrastructure.persistence.mapper;

import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskEntityMapper {

    Task toDomain(TaskEntity taskEntity);
    TaskEntity toEntity(Task task);

}
