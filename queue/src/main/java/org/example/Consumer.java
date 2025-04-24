package org.example;

import java.util.UUID;

public class Consumer {
    private String id;
    private QueueService queueService;
    private String name;

    public Consumer(String name, QueueService queueService) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.queueService = queueService;
    }

    public void notifyMessage(String topicName, String message) {
        System.out.println("Consumer: " + this.name + " Received message " + message + " from topic " + topicName);

    }

}
