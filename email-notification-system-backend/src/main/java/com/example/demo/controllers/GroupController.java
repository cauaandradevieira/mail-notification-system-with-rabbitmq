package com.example.demo.controllers;


import com.example.demo.dto.contact_group.request.GroupContactRequest;
import com.example.demo.dto.contact_group.response.GroupWithContactsResponse;
import com.example.demo.dto.contact_group.response.GroupsWithContactsQuantityDTO;
import com.example.demo.dto.group.request.GroupRequest;
import com.example.demo.dto.group.response.GroupResponse;
import com.example.demo.services.GroupService;
import com.example.demo.services.relation.ContactGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final ContactGroupService contactGroupService;

    @PostMapping
    public ResponseEntity<GroupResponse> create(
            @Valid @RequestBody GroupRequest request) {

        GroupResponse response = groupService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/contact")
    public ResponseEntity<Void> saveContact(@RequestBody GroupContactRequest request) {
        contactGroupService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<GroupsWithContactsQuantityDTO>> findAllGroupsWithContactsQuantity() {
        List<GroupsWithContactsQuantityDTO> response = contactGroupService.findAllGroupsWithContactsQuantity();

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    //@GetMapping
    //public ResponseEntity<List<GroupResponse>> findAll() {
        //return ResponseEntity.ok(groupService.findAll());
    //}

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(groupService.findById(id));
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<GroupWithContactsResponse> findAllContactsWithGroup(@PathVariable Long id)
    {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(contactGroupService.findAllContactsByGroupId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody GroupRequest request) {

        return ResponseEntity.ok(groupService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
