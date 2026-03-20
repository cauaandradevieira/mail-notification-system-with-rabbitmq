package com.example.demo.dto.contact_group.response;


import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.dto.group.response.GroupResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record GroupWithContactsResponse(
        GroupResponse group,
        List<ContactResponse> contacts
) {
}
