package com.example.demo.services;

import com.example.demo.dto.group.request.GroupRequest;
import com.example.demo.dto.group.response.GroupResponse;
import com.example.demo.entity.Group;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupResponse create(GroupRequest request) {

        Group group = groupMapper.toEntity(request);

        group.setCreatedAt(Instant.now());
        group.setUpdatedAt(Instant.now());

        Group saved = groupRepository.save(group);

        return groupMapper.toDto(saved);
    }

    public List<GroupResponse> findAll() {

        List<Group> groups = groupRepository.findAll();

        return groupMapper.toDtoList(groups);
    }

    public Group findByIdToEntity(Long id) {

        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo de contatos não encontrado"));
    }

    public GroupResponse findById(Long id) {

        Group group = findByIdToEntity(id);

        return groupMapper.toDto(group);
    }

    public GroupResponse update(Long id, GroupRequest request) {

        Group existing = findByIdToEntity(id);

        existing.setName(request.name());
        existing.setUpdatedAt(Instant.now());

        Group updated = groupRepository.save(existing);

        return groupMapper.toDto(updated);
    }

    public void delete(Long id) {

        Group group = findByIdToEntity(id);

        groupRepository.delete(group);
    }
}
