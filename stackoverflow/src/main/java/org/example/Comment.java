package org.example;

import java.util.Date;

public class Comment {
    private static int commentCounter = 1;
    private final int id;
    private final User author;
    private final String content;
    private final Date createdAt;

    public Comment(User author, String content) {
        this.author = author;
        this.content = content;
        this.id = commentCounter++;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
