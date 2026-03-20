package com.example.demo.mapper;

import com.example.demo.dto.contact.request.ContactRequest;
import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.dto.contact_group.projections.GroupsWithContactsQuantityProjection;
import com.example.demo.dto.contact_group.response.GroupWithContactsResponse;
import com.example.demo.dto.contact_group.response.GroupsWithContactsQuantityDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactGroup;
import com.example.demo.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactGroupMapper {

    private final ContactMapper contactMapper;
    private final GroupMapper groupMapper;

    public GroupWithContactsResponse toGroupWithContactsDTO(List<ContactGroup> contactGroupList)
    {
        List<Contact> contactList = contactGroupList.stream()
                .map(ContactGroup::getContact)
                .toList();

        Group group = contactGroupList.getFirst().getGroup();

        return GroupWithContactsResponse.builder()
                .group(groupMapper.toDto(group))
                .contacts(contactMapper.toDtoList(contactList))
                .build();
    }

    public List<GroupsWithContactsQuantityDTO> toGroupsWithContactsQuantityDTO(List<GroupsWithContactsQuantityProjection> projection)
    {
        return projection.stream()
                .map(p -> GroupsWithContactsQuantityDTO.builder()
                        .groupResponse(groupMapper.toDto(p.getGroup()))
                        .contactsQuantity(p.getContactQuantity())
                        .build())
                .toList();
    }


}
