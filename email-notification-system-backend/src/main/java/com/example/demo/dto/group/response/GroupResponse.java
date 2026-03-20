package com.example.demo.dto.group.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record GroupResponse(
        Long id,
        String name,
        String color,
        Instant createdAt,
        Instant updatedAt
) {
}
