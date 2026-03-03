package com.example.demo.controllers;


import com.example.demo.dto.contact_group.response.ContactsWithGroupResponse;
import com.example.demo.dto.group.request.GroupRequest;
import com.example.demo.dto.group.response.GroupResponse;
import com.example.demo.entity.Group;
import com.example.demo.mapper.ContactGroupMapper;
import com.example.demo.mapper.GroupMapper;
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
    private final GroupMapper groupMapper;

    @PostMapping
    public ResponseEntity<Void> create(
            @Valid @RequestBody GroupRequest request) {

        Group group = groupMapper.toEntity(request);

        group.setName(request.name());

        groupService.create(group);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> findAll() {

        List<Group> groups = groupService.findAll();

        List<GroupResponse> response = groupMapper.toDtoList(groups);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponse> findById(
            @PathVariable Long id) {

        Group group = groupService.findById(id);

        GroupResponse response = groupMapper.toDto(group);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<ContactsWithGroupResponse> findAllContactsWithGroup(@PathVariable Long id)
    {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(contactGroupService.findAllContactsByGroupId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @Valid @RequestBody GroupRequest request) {

        Group group = groupMapper.toEntity(request);

        groupService.update(id, group);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        groupService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
