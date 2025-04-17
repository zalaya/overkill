package dev.zalaya.overkill.backend.infrastructure.assertions;

import dev.zalaya.overkill.api.model.TaskInputDto;
import dev.zalaya.overkill.backend.domain.model.Task;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class TaskInputDtoAssertions extends AbstractAssert<TaskInputDtoAssertions, TaskInputDto> {

    private TaskInputDtoAssertions(TaskInputDto actual) {
        super(actual, TaskInputDtoAssertions.class);
    }

    public static TaskInputDtoAssertions assertThat(TaskInputDto actual) {
        return new TaskInputDtoAssertions(actual);
    }

    public TaskInputDtoAssertions hasSameFieldsAs(Task expected) {
        isNotNull();

        Assertions.assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        Assertions.assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        Assertions.assertThat(actual.getPriority().toString()).isEqualTo(expected.getPriority().toString());
        Assertions.assertThat(actual.getExpiresAt()).isEqualTo(expected.getExpiresAt());

        return this;
    }

}
