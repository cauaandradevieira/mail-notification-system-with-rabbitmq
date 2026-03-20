package com.example.demo.error.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GroupError {

    GROUP_NOT_FOUND(HttpStatus.NOT_FOUND, "Grupo não encontrado."),
    GROUP_NO_EXISTS(HttpStatus.CONFLICT, "Esse grupo já existe no sistema.");

    private final HttpStatus status;
    private final String message;
}
