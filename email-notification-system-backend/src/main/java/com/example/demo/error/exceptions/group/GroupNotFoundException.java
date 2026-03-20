package com.example.demo.error.exceptions.group;

import com.example.demo.error.enums.GroupError;
import lombok.Getter;

@Getter
public class GroupNotFoundException extends RuntimeException
{
    private final GroupError error;

    public GroupNotFoundException(GroupError error) {
        super(error.getMessage());
        this.error = error;
    }
}
