package com.example.demo.dto.group.request;

import jakarta.validation.constraints.NotBlank;

public record GroupRequest(
        @NotBlank String name,
        String color
) {
}
