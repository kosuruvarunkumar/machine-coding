package org.example;

import java.util.UUID;

public class Producer {
    private final String id;
    private final QueueService queueService;

    public Producer(QueueService queueService) {
        this.id = UUID.randomUUID().toString();
        this.queueService = queueService;
    }

    public void publish(String message, String topicName) {
        queueService.publishMessage(this.id, message, topicName);
    }

    public String getId() {
        return id;
    }
}
