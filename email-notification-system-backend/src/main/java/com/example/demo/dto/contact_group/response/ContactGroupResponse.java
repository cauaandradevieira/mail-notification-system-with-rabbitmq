package com.example.demo.dto.contact_group.response;

import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.dto.group.response.GroupResponse;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Group;
import lombok.Builder;

import java.util.List;

@Builder
public record ContactGroupResponse(List<ContactResponse> contacts, GroupResponse groups) {
}

/*
    {
        group: {
            id:5,
            name:Dev dojo
            contacts: [
                {telephone,name,id,email}
                {telephone,name,id,email}
                {telephone,name,id,email}
                {telephone,name,id,email}
                {telephone,name,id,email}
            ]
        }
    }
 */
