package com.example.demo.entity;

import com.example.demo.entity.mapsId.ContactGroupId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "contact_group")
@Getter
@Setter
public class ContactGroup {

    @EmbeddedId
    private ContactGroupId contactGroupId;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @MapsId("contactId")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "created_at")
    private Instant createdAt;
}
