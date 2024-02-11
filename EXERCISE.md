# Exercise: Messaging System using RabbitMQ

## Goal
This exercise involves Java Spring Boot, RabbitMQ, JSON for message queuing, and a consumer Spring Boot 
application. You will understand how to produce and consume messages using a message queue in a Spring Boot application. 
The messages will represent items with IDs, names, descriptions, picture links, and prices in Euros. 

## Objectives
Implement two Spring Boot applications that use the RabbitMQ message broker. One application will produce messages
containing items and the other application will consume these messages and log the details of each item.

*Note: As a base example you can use the given code, where the steps are implemented already.*

## Part 1: Producer Application

### Step 1: Set Up Spring Boot Project
Create a new Spring Boot project, for example by using Spring Initializr (https://start.spring.io/). Include the 
following dependencies:
- Spring Web: `spring-boot-starter-web`
- Spring for RabbitMQ (AMQP): `spring-boot-starter-amqp`
- Lombok: `lombok`

### Step 2: Configure RabbitMQ
In `application.properties`, configure the RabbitMQ connection:
```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### Step 3: Define the Item Model
Create a Java class `Item` with the following properties:
- `id` (String)
- `name` (String)
- `description` (String)
- `pictureUrl` (String)
- `price` (double)

Include getters, setters, and a toString method by using *Lombok*.

### Step 4: Create a Message Sender
Define a service class `RabbitMQSender` with a method to send item messages. Use `RabbitTemplate` for sending messages 
to a queue named `itemsQueue`.

### Step 5: Create a REST Controller
Implement a REST controller `ItemController` with a POST endpoint to send item messages. Use the `RabbitMQSender` to 
send messages.

## Consumer Application

### Step 1: Set Up Another Spring Boot Project
Similar to Part 1, but this time, focus on the AMQP dependency for consuming messages.

### Step 2: Configure RabbitMQ
Ensure the `application.properties` matches the producer application for RabbitMQ settings.

### Step 3: Create a Message Listener
Implement a message listener that consumes messages from the `itemsQueue`. Parse the received message back into an 
`Item` object and log it to the console.

## RabbitMQ Server
Run the RabbitMQ server in a Docker container. Either use a `docker-compose.yml` file to start it or run it from the
command line. Consider the RabbitMQ documentation on DockerHub for more information: https://hub.docker.com/_/rabbitmq.

*Note: Ensure you pull the RabbitMQ image `rabbitmq:3-management` that includes management interface.*

## Application Test
1. Start the RabbitMQ server.
2. Run both Spring Boot applications locally (not in a Docker network).
3. Use your favorite REST client to send a POST request to the producer application with an item JSON payload.
4. Verify that the consumer application receives the message and logs the item details.

## Hints
Your can check your message queues by the RabbitMQ management interface running on `http://localhost:15672`. 

## Bonus
Implement an `Item` object on consumer side and use its `toString()` method to log the item details to the console.
