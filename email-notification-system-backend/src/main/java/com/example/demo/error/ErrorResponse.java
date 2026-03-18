package com.example.demo.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class ErrorResponse {

    private Integer status;
    private String code;
    private String message;

    @Builder.Default
    private Instant instant = Instant.now();

    @Builder.Default
    private Map<String, String> extras = new HashMap<>();

}
