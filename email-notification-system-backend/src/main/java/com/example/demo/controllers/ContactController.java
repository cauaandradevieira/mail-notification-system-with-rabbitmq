package com.example.demo.controllers;

import com.example.demo.dto.contact.request.ContactRequest;
import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.entity.Contact;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @PostMapping
    public ResponseEntity<ContactResponse> create(@Valid @RequestBody ContactRequest request) {

        Contact contact = contactMapper.toEntity(request);
        Contact saved = contactService.create(contact);

        ContactResponse response = contactMapper.toDto(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> findAll() {

        List<Contact> contacts = contactService.findAll();

        List<ContactResponse> response = contactMapper.toDtoList(contacts);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> findById(@PathVariable Long id) {

        Contact contact = contactService.findById(id);

        ContactResponse response = contactMapper.toDto(contact);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ContactRequest request) {

        Contact contact = contactMapper.toEntity(request);

        Contact updated = contactService.update(id, contact);

        ContactResponse response = contactMapper.toDto(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        contactService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
