package dev.zalaya.overkill.backend.domain.port.outbound;

import dev.zalaya.overkill.backend.domain.model.Task;

public interface TaskRepository {

    void save(Task task);

}
