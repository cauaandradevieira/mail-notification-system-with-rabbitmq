package com.example.demo.dto.contact_group.response;

import com.example.demo.dto.group.response.GroupResponse;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record GroupsWithContactsQuantityDTO(

        @JsonProperty("group")
        GroupResponse groupResponse,
        Long contactsQuantity) {
}
