package org.example.storage;

import org.example.Consumer;
import org.example.Message;

public interface MessageStorage {
    void createTopic(String topicName);
    void addMessage(Message message, String topicName);
    void addSubscriber(String topicName, Consumer consumer);
}
