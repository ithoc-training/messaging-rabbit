package de.ithoc.messaging.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produces")
public class MessageProducerController {

    private final MessageProducerService messageProducerService;

    public MessageProducerController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }


    @PostMapping
    public ResponseEntity<Void> produceMessage(@RequestBody QueueMessage queueMessage) {

        messageProducerService.sendToQueue(queueMessage.getContent());

        return ResponseEntity.status(201).build();
    }

}
