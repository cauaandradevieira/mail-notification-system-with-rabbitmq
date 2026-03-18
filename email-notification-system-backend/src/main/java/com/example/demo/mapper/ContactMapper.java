package com.example.demo.mapper;

import com.example.demo.dto.contact.request.ContactRequest;
import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.entity.Contact;
import jakarta.validation.ConstraintValidator;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class ContactMapper {

    public ContactResponse toDto(Contact contact)
    {
        return ContactResponse.builder()
                .id(contact.getId())
                .email(contact.getEmail())
                .name(contact.getName())
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
