package org.example;

public class Tag {
    private static int tagCounter = 1;
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tag(String name) {
        this.id = tagCounter++;
        this.name = name;
    }
}
