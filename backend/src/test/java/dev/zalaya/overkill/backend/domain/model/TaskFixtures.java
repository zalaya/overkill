package dev.zalaya.overkill.backend.domain.model;

public class TaskFixtures {

    public static Task aTaskWith(String title, Priority priority) {
        return Task.builder()
            .title(title)
            .priority(priority)
            .build();
    }

}
