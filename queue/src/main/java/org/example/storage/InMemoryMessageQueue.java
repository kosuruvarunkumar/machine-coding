package org.example.storage;

import org.example.Consumer;
import org.example.Message;
import org.example.Topic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMessageQueue implements MessageStorage {
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();
    @Override
    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    @Override
    public void addMessage(Message message, String topicName) {
        Topic topic = topics.get(topicName);
        if(topic != null) {
            topic.addMessage(message);
            for(Consumer consumer : topic.getAllSubscribers()) {
                consumer.notifyMessage(topicName, message.getMessage());
            }
        }
    }

    @Override
    public void addSubscriber(String topicName, Consumer consumer) {
        Topic topic = topics.get(topicName);
        if(topic != null) {
            topic.addSubscriber(consumer);
        }
    }
}
