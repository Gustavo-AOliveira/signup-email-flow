package com.ms.email.consumers;

import com.ms.email.dtos.EmailRequestDto;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRequestDto emailRequestDto) {
        System.out.println("Message received: " + emailRequestDto.emailTo());
        var email = new Email();
        BeanUtils.copyProperties(emailRequestDto, email);
        emailService.sendEmail(email);
    }
}
