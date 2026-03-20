package com.example.demo.services.relation;

import com.example.demo.dto.contact_group.projections.GroupsWithContactsQuantityProjection;
import com.example.demo.dto.contact_group.request.GroupContactRequest;
import com.example.demo.dto.contact_group.response.GroupWithContactsResponse;
import com.example.demo.dto.contact_group.response.GroupsWithContactsQuantityDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactGroup;
import com.example.demo.entity.Group;
import com.example.demo.error.enums.GroupError;
import com.example.demo.error.exceptions.group.GroupNotFoundException;
import com.example.demo.mapper.ContactGroupMapper;
import com.example.demo.repository.ContactGroupRepository;
import com.example.demo.services.ContactService;
import com.example.demo.services.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactGroupService {

    private final ContactGroupRepository contactGroupRepository;
    private final ContactService contactService;
    private final GroupService groupService;
    private final ContactGroupMapper contactGroupMapper;

    @Transactional
    public void save(GroupContactRequest request)
    {
        List<Contact> contactList = contactService.findAllById(request.contactIdList());
        Group group = groupService.findByIdToEntity(request.groupId());

        List<ContactGroup> contactGroupList = contactList.stream()
                .map(c -> {
                            ContactGroup contactGroup  = new ContactGroup();
                            contactGroup.setContact(c);
                            contactGroup.setGroup(group);
                            contactGroup.setCreatedAt(Instant.now());

                            return contactGroup;
                        })
                .toList();

        contactGroupRepository.saveAll(contactGroupList);
    }

    public GroupWithContactsResponse findAllContactsByGroupId(Long groupId)
    {
        List<ContactGroup> contactList = contactGroupRepository.findAllContactsByGroupId(groupId);

        if(contactList.isEmpty())
        {
            throw new GroupNotFoundException(GroupError.GROUP_NOT_FOUND);
        }

        return contactGroupMapper.toGroupWithContactsDTO(contactList);
    }

    public List<GroupsWithContactsQuantityDTO> findAllGroupsWithContactsQuantity()
    {
        List<GroupsWithContactsQuantityProjection> projection = contactGroupRepository.findAllGroupsWithContactsQuantity();

        return contactGroupMapper.toGroupsWithContactsQuantityDTO(projection);
    }
}
