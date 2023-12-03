package com.example.Cataloguemicroservice.jms;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }
    public void sendProduct(ProductDTO productDTO) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(productDTO);
            String destination = "ProductToStock";
            jmsTemplate.send(destination, session -> {
                javax.jms.TextMessage message = session.createTextMessage(jsonMessage);
                return message;
            });
            System.out.println("Product envoyé avec succès à la file d'attente " + destination);
        } catch (JsonProcessingException e) {
            System.err.println("Error converting Product to JSON: " + e.getMessage());
        }
    }
    public void sendMessage(String messageText) {

        String destination = "ProductToStock";

        jmsTemplate.send(destination, session -> {
            javax.jms.TextMessage message = session.createTextMessage(messageText);
            return message;
        });
        System.out.println("Message envoyé avec succès à la file d'attente " + destination);
    }
}
