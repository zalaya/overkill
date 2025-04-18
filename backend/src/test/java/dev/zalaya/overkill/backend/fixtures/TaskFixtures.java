package dev.zalaya.overkill.backend.fixtures;

import dev.zalaya.overkill.backend.domain.model.Priority;
import dev.zalaya.overkill.backend.domain.model.Task;

public class TaskFixtures {

    public static Task aTaskWith(String title, Priority priority) {
        return Task.builder()
            .title(title)
            .priority(priority)
            .build();
    }

}
