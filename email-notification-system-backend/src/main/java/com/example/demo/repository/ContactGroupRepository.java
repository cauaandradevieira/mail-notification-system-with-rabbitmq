package com.example.demo.repository;

import com.example.demo.dto.contact.response.ContactResponse;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup,Long> {

    @Query("SELECT cg FROM ContactGroup AS cg " +
            "JOIN FETCH cg.group AS group " +
            "JOIN FETCH cg.contact AS contact " +
            "WHERE group.id = :groupId")
    List<ContactGroup> findAllContactsByGroupId(@Param("groupId") Long groupId);
}
