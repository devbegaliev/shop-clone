package com.example.shop_clone.service.user;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private MailSender mailSender;

    public void send(String to, String title, String content) {
           SimpleMailMessage mailMessage = new SimpleMailMessage();
           mailMessage.setTo(to);
           mailMessage.setSubject(title);
           mailMessage.setText(content);
           mailSender.send(mailMessage);
    }
}
