package com.example.demo.rabbit.message;

import lombok.Builder;

@Builder
public record EmailMessage(Long contactId,
                           String title,
                           String subject,
                           String body) {
}
