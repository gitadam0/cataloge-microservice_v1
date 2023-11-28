package com.example.Cataloguemicroservice.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String messageText) {

        String destination = "TEST-TOPIC-team5";

        jmsTemplate.send(destination, session -> {
            javax.jms.TextMessage message = session.createTextMessage(messageText);
            return message;
        });
        System.out.println("Message envoyé avec succès à la file d'attente " + destination);
    }
}
