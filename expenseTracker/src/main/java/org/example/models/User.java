package org.example.models;

import java.util.UUID;

public class User {
    String id;
    String name;
    String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public User(String name, String email) {
        this.id = "U-" + UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }
}
