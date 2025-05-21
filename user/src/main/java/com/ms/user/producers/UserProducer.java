package com.ms.user.producers;

import com.ms.user.models.Email;
import com.ms.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Value("${broker.queue.email.name}")
    private String routingKey;


    public void sendMessage(User user) {
        Email email = new Email();
        email.setUserId(user.getUser_id());
        email.setEmailTo(user.getEmail());
        email.setSubject("Cadastro realizado com sucesso!");
        email.setText("Olá " + user.getName() + ", seu cadastro foi realizado com sucesso!");

        rabbitTemplate.convertAndSend("", routingKey, email);
    }
}
