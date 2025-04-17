package dev.zalaya.overkill.backend.application.mapper;

import dev.zalaya.overkill.api.model.TaskInputDto;
import dev.zalaya.overkill.backend.domain.model.Task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskInputDtoMapper {

    Task toDomain(TaskInputDto taskEntity);
    List<Task> toDomain(List<TaskInputDto> taskEntities);

    TaskInputDto toDto(Task task);
    List<TaskInputDto> toDto(List<Task> tasks);

}
