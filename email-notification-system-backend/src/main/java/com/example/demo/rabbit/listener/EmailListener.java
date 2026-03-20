package com.example.demo.rabbit.listener;

import com.example.demo.dto.email.request.EmailRequest;
import com.example.demo.rabbit.message.EmailMessage;
import com.example.demo.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailListener
{
    private final EmailService emailService;

    @RabbitListener(queues = "email.queue")
    public void send(EmailMessage message)
    {
        emailService.send(message);
    }
}
