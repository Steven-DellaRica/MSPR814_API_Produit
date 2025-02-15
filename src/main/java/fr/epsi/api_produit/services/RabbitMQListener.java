package fr.epsi.api_produit.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    @RabbitListener(queues = "produitQueue")
    public void recevoirMessageProduit(String message) {
        System.out.println("Message reçu dans API_Produit : " + message);
    }
}
