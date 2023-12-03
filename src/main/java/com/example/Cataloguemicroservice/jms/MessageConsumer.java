package com.example.Cataloguemicroservice.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "ProductToSt", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        System.out.println(" Message reçu du topicccccccccccccccccccccccccc");
        System.out.println("Message reçu du topic : " + message);
    }
}
