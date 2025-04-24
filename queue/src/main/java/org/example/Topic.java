package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    private final List<Message> messages;
    private final Set<Consumer> subscribers;

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addSubscriber(Consumer consumer) {
        subscribers.add(consumer);
    }

    public Set<Consumer> getAllSubscribers() {
        return subscribers;
    }
}
