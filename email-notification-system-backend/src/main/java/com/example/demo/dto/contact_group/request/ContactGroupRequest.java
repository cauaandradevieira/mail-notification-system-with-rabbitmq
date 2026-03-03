package com.example.demo.dto.contact_group.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record ContactGroupRequest(@NotNull @Positive @JsonAlias("group") Long groupId,
                                  @JsonAlias("contacts") List<@NotNull @Positive Long>  contactIdList) {
}
