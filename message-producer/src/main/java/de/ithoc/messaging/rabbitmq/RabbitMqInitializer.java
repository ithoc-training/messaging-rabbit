package de.ithoc.messaging.rabbitmq;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqInitializer {

    @Value("${rabbitmq.queue.name}")
    private String name;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonName;

    private final AmqpAdmin amqpAdmin;

    public RabbitMqInitializer(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }


    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue(name, true));
        amqpAdmin.declareQueue(new Queue(jsonName, true));
    }

}
