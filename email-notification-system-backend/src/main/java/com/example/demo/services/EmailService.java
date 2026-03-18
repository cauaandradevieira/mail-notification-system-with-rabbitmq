package com.example.demo.services;

import com.example.demo.dto.email.request.EmailRequest;
import com.example.demo.entity.Contact;
import com.example.demo.rabbit.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final ContactService contactService;

    public void send(EmailMessage request)
    {
        // pegar o contato no banco e verificar se existe
        Contact contact = contactService.findById(request.contactId());

        // request contem caracteres como {nome} e etc... que deve ser trocados por dados

        // mensagem = Olá {nome}, hoje dia 5 estaremos fazendo uma festa em comemoração do dia do funcionario

        String messageFormatted = request.body()
                .replace("{nome}", contact.getName())
                .replace("{email}", contact.getEmail());

        // se a mensagem conter o caracter {nome} faça isso:

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(contact.getEmail());
        simpleMailMessage.setSubject(request.subject());
        simpleMailMessage.setText(messageFormatted);

        javaMailSender.send(simpleMailMessage);
    }
}
