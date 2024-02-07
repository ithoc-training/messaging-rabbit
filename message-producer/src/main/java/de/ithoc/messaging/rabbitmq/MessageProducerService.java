package de.ithoc.messaging.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    public MessageProducerService(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }


    /**
     * Send a message to the configured queue.
     */
    public void sendToQueue(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

}
