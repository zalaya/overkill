package dev.zalaya.overkill.backend.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Task {

    String title;
    String description;
    Priority priority;
    LocalDateTime expiresAt;

}
