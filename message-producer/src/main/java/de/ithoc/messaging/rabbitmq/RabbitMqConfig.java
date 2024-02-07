package de.ithoc.messaging.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.name}")
    private String name;

    @Value("${rabbitmq.queue.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonName;

    @Value("${rabbitmq.queue.json.routing.key}")
    private String jsonRoutingKey;

    /**
     * Generate the queue in RabbitMQ when starting.
     * @return Queue
     */
    @Bean
    public Queue queue() {
        return new Queue(name);
    }

    @Bean
    public Queue jsonQueue() {
        return new Queue(jsonName);
    }
}
