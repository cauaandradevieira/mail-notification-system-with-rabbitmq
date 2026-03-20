package com.example.demo.error.exceptions_handlers;

import com.example.demo.error.ErrorResponse;
import com.example.demo.error.exceptions.group.GroupNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GroupExceptionHandler {

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<ErrorResponse> groupNotFoundExceptionHandler(GroupNotFoundException ex)
    {
        ErrorResponse response = ErrorResponse.builder()
                .status(ex.getError().getStatus().value())
                .code(ex.getError().name())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(ex.getError().getStatus())
                .body(response);
    }
}
