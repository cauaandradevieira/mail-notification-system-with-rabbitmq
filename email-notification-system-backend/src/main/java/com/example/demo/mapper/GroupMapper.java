package com.example.demo.mapper;

import com.example.demo.dto.contact_group.projections.GroupSumary;
import com.example.demo.dto.contact_group.projections.GroupsWithContactsQuantityProjection;
import com.example.demo.dto.group.request.GroupRequest;
import com.example.demo.dto.group.response.GroupResponse;
import com.example.demo.entity.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupMapper
{
    public GroupResponse toDto(Group group) {
        return new GroupResponse(
                group.getId(),
                group.getName(),
                group.getColor(),
                group.getCreatedAt(),
                group.getUpdatedAt()
        );
    }

    public GroupResponse toDto(GroupSumary projection) {
        return GroupResponse.builder()
                .id(projection.getId())
                .name(projection.getName())
                .color(projection.getColor())
                .createdAt(projection.getCreatedAt())
                .updatedAt(projection.getUpdatedAt())
                .build();
    }

    public List<GroupResponse> toDtoList(List<Group> groups) {
        return groups.stream()
                .map(this::toDto)
                .toList();
    }

    public Group toEntity(GroupRequest request) {
        Group group = new Group();
        group.setName(request.name());
        group.setColor(request.color());
        return group;
    }
}
