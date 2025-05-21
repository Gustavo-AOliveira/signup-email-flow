package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    final EmailRespository emailRespository;
    final JavaMailSender emailSender;

    public EmailService(EmailRespository emailRespository, JavaMailSender emailSender) {
        this.emailRespository = emailRespository;
        this.emailSender = emailSender;
    }
    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public Email sendEmail(Email email){
        try {
            email.setSendDateEmail(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
            email.setStatus(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatus(StatusEmail.ERROR);
        } finally {
            var newEmail = emailRespository.save(email);
            return newEmail;
        }
    }
}
