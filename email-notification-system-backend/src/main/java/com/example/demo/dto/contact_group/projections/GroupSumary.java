package com.example.demo.dto.contact_group.projections;

import java.time.Instant;

public interface GroupSumary {
    Long getId();
    String getName();
    String getColor();
    Instant getCreatedAt();
    Instant getUpdatedAt();
}
