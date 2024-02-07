package de.ithoc.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageConsumerService {


    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveFromQueue(String message) {

        System.out.println("Message received at " + LocalDateTime.now() + ":");
        System.out.println(message);

        // Implement message processing here
    }

}
