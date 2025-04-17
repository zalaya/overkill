package dev.zalaya.overkill.backend.infrastructure.assertions;

import dev.zalaya.overkill.api.model.TaskInputDto;
import dev.zalaya.overkill.backend.domain.model.Task;
import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class TaskAssertions extends AbstractAssert<TaskAssertions, Task> {

    private TaskAssertions(Task actual) {
        super(actual, TaskAssertions.class);
    }

    public static TaskAssertions assertThat(Task actual) {
        return new TaskAssertions(actual);
    }

    public TaskAssertions hasSameFieldsAs(TaskEntity expected) {
        isNotNull();

        Assertions.assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        Assertions.assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        Assertions.assertThat(actual.getPriority()).isEqualTo(expected.getPriority());
        Assertions.assertThat(actual.getExpiresAt()).isEqualTo(expected.getExpiresAt());

        return this;
    }

    public TaskAssertions hasSameFieldsAs(TaskInputDto expected) {
        isNotNull();

        Assertions.assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        Assertions.assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        Assertions.assertThat(actual.getPriority().toString()).isEqualTo(expected.getPriority().toString());
        Assertions.assertThat(actual.getExpiresAt()).isEqualTo(expected.getExpiresAt());

        return this;
    }

}
