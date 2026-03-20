package com.example.demo.rabbit.producer;

import com.example.demo.dto.email.request.EmailRequest;
import com.example.demo.rabbit.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendToQueue(EmailRequest request)
    {
        request.contactIds().forEach(i -> {
            EmailMessage message = EmailMessage.builder()
                    .contactId(i)
                    .title(request.title())
                    .body(request.body())
                    .subject(request.subject())
                    .build();

            rabbitTemplate.convertAndSend(
                    "email.exchange",
                    "email.routing",
                    message);
        });
    }
}
