package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable{
    private static int questionCounter = 1;
    private final int id;
    private final String title;
    private final String description;
    private final User author;
    private final Date createdAt;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;

    public Question(String title, String description, User author, List<Tag> tags) {
        this.id = questionCounter++;
        this.title = title;
        this.description = description;
        this.author = author;
        this.tags = tags;
        this.createdAt = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    @Override
    public void addVote(User user, int value) {
        votes.removeIf(vote -> vote.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value * 5);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

}
