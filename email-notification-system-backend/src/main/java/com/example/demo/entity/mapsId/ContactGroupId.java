package com.example.demo.entity.mapsId;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record ContactGroupId(Long contactId, Long groupId) implements Serializable {
}
