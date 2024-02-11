# Messaging RabbitMQ

## Overview

This messaging system is based on the RabbitMQ message broker. It consists of a producer and a consumer. The producer 
sends a message to the RabbitMQ queue and the consumer listens to the queue and consumes the message.

## Configuration

Following environment variables are required to be set in order to run the application.
```properties
SPRING_RABBITMQ_HOST=rabbitmq
SPRING_RABBITMQ_PORT=5672
SPRING_RABBITMQ_USERNAME=<USERNAME>
SPRING_RABBITMQ_PASSWORD=<PASSWORD>
```
Locally, standard username and password are `guest` and `guest` respectively. 
Do not use these credentials in production.

## Implementation

Run the application by executing starting the Docker containers:

```shell
docker compose up -d
```
Note:
It might take a while that the RabbitMQ container is up and running. If the producer and consumer are started before the
message broker, they will fail to connect to the broker and you'll see some error messages like 
- `Error creating bean with name 'rabbitMqInitializer': Invocation of init method failed` and 
- `Connection refused`. 

Give it some time and connection will be established.

The message broker now listens on `localhost:5672`. The producer and consumer are running in the same container network.

## Testing
Open an HTTP client (e.g. cURL or Postman) and run this request:
```shell
curl --location 'http://localhost:18088/api/produces' \
--header 'Content-Type: application/json' \
--data '{
    "content": "RabbitMQ is an open-source message-broker software (sometimes called message-oriented middleware) that originally implemented the Advanced Message Queuing Protocol (AMQP) and has since been extended with a plug-in architecture to support Streaming Text Oriented Messaging Protocol (STOMP), MQ Telemetry Transport (MQTT), and other protocols."
}'
``` 

You should see the message in the consumer's log output.
```
message-consumer  | RabbitMQ is an open-source message-broker software (sometimes called message-oriented middleware) 
that originally implemented the Advanced Message Queuing Protocol (AMQP) and has since been extended with a plug-in 
architecture to support Streaming Text Oriented Messaging Protocol (STOMP), MQ Telemetry Transport (MQTT), and other 
protocols.
```