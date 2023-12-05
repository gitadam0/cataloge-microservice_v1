package com.example.Cataloguemicroservice.Services.MessagingService;

import com.example.Cataloguemicroservice.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class YourMessagingService {
    @Autowired
    private JmsTemplate jmsTemplate;

    // Assuming 'yourQueue' is the name of the JMS queue you want to send messages to
    private static final String YOUR_QUEUE = "TEST-TOPIC-Catalogue";

    public void sendProduct(Product product) {
        jmsTemplate.convertAndSend(YOUR_QUEUE, product);
    }
}
