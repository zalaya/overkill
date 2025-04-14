package dev.zalaya.overkill.backend.domain.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Task {

    String title;
    String description;
    Priority priority;
    LocalDateTime expiresAt;

}
