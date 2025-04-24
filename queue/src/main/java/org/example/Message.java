package org.example;

import java.util.Date;

public class Message {
    private final String message;
    private final Date timestamp;
    private final String producerId;

    public Message(String producerId, String message) {
        this.message = message;
        this.producerId = producerId;
        this.timestamp = new Date();
    }

    public String getProducerId() {
        return producerId;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
