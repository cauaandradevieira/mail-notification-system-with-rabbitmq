package com.example.demo.services;

import com.example.demo.entity.Contact;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.repository.ContactRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService
{
    private final ContactRepository contactRepository;
    private final ContactMapper mapper;

    @Transactional
    public Contact create(Contact contact)
    {
        contact.setCreatedAt(Instant.now());
        contact.setUpdatedAt(Instant.now());
        return contactRepository.save(contact);
    }

    public List<Contact> findAll()
    {
        return contactRepository.findAll();
    }

    public List<Contact> findAllById(List<Long> idList) {
        return contactRepository.findAllById(idList);
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("contact entity not found"));
    }

    @Transactional
    public Contact update(Long id, Contact updatedContact)
    {
        Contact contact = findById(id);

        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setTelephone(updatedContact.getTelephone());
        contact.setUpdatedAt(Instant.now());

        return contactRepository.save(contact);
    }

    @Transactional
    public void delete(Long id) {

    }


}
