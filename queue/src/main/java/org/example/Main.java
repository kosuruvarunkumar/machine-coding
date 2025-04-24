package org.example;

import org.example.storage.InMemoryMessageQueue;
import org.example.storage.MessageStorage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MessageStorage messageStorage = new InMemoryMessageQueue();
        QueueService queueService = new QueueService(messageStorage);

        queueService.createTopic("1");
        queueService.createTopic("2");
        queueService.createTopic("3");

        Producer producer1 = new Producer(queueService);
        Producer producer2 = new Producer(queueService);

        Consumer consumer1 = new Consumer("C1", queueService);
        Consumer consumer2 = new Consumer("C2", queueService);

        queueService.subscribe("1", consumer1);
        queueService.subscribe("2", consumer1);
        queueService.subscribe("1", consumer2);


        queueService.publishMessage(producer1.getId(), "Message 1", "1");

        queueService.publishMessage(producer2.getId(), "Message 2", "2");

        queueService.publishMessage(producer1.getId(), "Message 3", "3");

    }
}