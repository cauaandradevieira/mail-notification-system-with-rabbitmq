package com.example.demo.dto.contact.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ContactResponse(
        Long id,
        String name,
        String email,
        String telephone,
        Instant createdAt,
        Instant updatedAt
) {
}
