package com.example.demo.dto.email.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record EmailRequest(@NotEmpty(message = "TO VAZIO") List<Long> contactIds,
                           @NotBlank(message = "TITLE VAZIO") String title,
                           @NotBlank(message = "SUBJECT VAZIO") String subject,
                           @NotBlank(message = "BODY VAZIO") String body) {
}
