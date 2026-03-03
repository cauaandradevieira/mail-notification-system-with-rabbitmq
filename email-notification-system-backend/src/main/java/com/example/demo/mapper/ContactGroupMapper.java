package com.example.demo.mapper;

import com.example.demo.dto.contact.request.ContactRequest;
import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.dto.contact_group.response.ContactGroupResponse;
import com.example.demo.dto.contact_group.response.ContactsWithGroupResponse;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactGroup;
import com.example.demo.entity.Group;
import jakarta.validation.ConstraintValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactGroupMapper {

    private final ContactMapper contactMapper;
    private final GroupMapper groupMapper;

    public ContactsWithGroupResponse toContactsWithGroupDto(List<ContactGroup> contactGroupList)
    {
        List<Contact> contactList = contactGroupList.stream()
                .map(ContactGroup::getContact)
                .toList();

        Group group = contactGroupList.getFirst().getGroup();

        return ContactsWithGroupResponse.builder()
                .group(groupMapper.toDto(group))
                .contacts(contactMapper.toDtoList(contactList))
                .build();
    }

    public ContactResponse toDto(Contact contact)
    {
        return ContactResponse.builder()
                .id(contact.getId())
                .email(contact.getEmail())
                .telephone(contact.getTelephone())
                .createdAt(contact.getCreatedAt())
                .updatedAt(contact.getUpdatedAt())
                .build();
    }

    public List<ContactResponse> toDtoList(List<Contact> contactList)
    {
        return contactList.stream()
                .map(this::toDto)
                .toList();
    }

    public Contact toEntity(ContactRequest request)
    {
        Contact contact = new Contact();

        contact.setName(request.name());
        contact.setEmail(request.email());
        contact.setTelephone(request.telephone());

        return contact;
    }
}
