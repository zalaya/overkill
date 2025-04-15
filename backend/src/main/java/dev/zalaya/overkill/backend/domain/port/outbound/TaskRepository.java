package dev.zalaya.overkill.backend.domain.port.outbound;

import dev.zalaya.overkill.backend.domain.model.Task;

import java.util.List;

public interface TaskRepository {

    Task save(Task task);
    List<Task> saveAll(List<Task> tasks);

}
