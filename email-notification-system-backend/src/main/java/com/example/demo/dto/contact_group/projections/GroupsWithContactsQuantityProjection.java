package com.example.demo.dto.contact_group.projections;

import java.time.Instant;

public interface GroupsWithContactsQuantityProjection {
    GroupSumary getGroup();
    Long getContactQuantity();
}
