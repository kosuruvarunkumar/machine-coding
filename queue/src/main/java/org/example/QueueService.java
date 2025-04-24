package org.example;

import org.example.storage.MessageStorage;

public class QueueService {
    private final MessageStorage messageStorage;

    public QueueService(MessageStorage messageStorage) {
        this.messageStorage = messageStorage;
    }

    public void createTopic(String topicName) {
        messageStorage.createTopic(topicName);
        System.out.println("Topic with name " + topicName +" created.");
    }

    public void publishMessage(String producerId, String message, String topicName) {
        messageStorage.addMessage(new Message(producerId, message), topicName);
    }

    public void subscribe(String topicName, Consumer consumer) {
        messageStorage.addSubscriber(topicName, consumer);
    }
}
