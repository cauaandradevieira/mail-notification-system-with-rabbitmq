package com.example.demo.controllers;

import com.example.demo.dto.email.request.EmailRequest;
import com.example.demo.rabbit.producer.EmailProducer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailProducer emailProducer;

    @PostMapping()
    public ResponseEntity<?> send(@Valid @RequestBody EmailRequest request)
    {
        emailProducer.sendToQueue(request);

        return ResponseEntity.ok().build();
    }
}
