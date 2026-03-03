package com.example.demo.dto.contact.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRequest(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String email,
        @NotBlank @NotNull String telephone
) {
}
