package com.example.demo.controllers;

import com.example.demo.dto.contact_group.request.ContactGroupRequest;
import com.example.demo.dto.contact_group.response.ContactGroupResponse;
import com.example.demo.entity.ContactGroup;
import com.example.demo.services.ContactService;
import com.example.demo.services.relation.ContactGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact/group")
@RequiredArgsConstructor
public class ContactGroupController {
    private final ContactGroupService contactGroupService;

    @PostMapping()
    public ResponseEntity<ContactGroup> create(@RequestBody ContactGroupRequest request) {
        contactGroupService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*
    @GetMapping()
    public ResponseEntity<?> finAll() {
        List<ContactGroupResponse> response = contactGroupService.findAll();
        return ResponseEntity.ok(response);
    }
    */

}
