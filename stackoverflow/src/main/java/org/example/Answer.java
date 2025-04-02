package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable {
    private static int answerCounter = 1;
    private int id;
    private String answer;
    private Question question;
    private boolean isAccepted;
    private List<Comment> comments;
    private List<Vote> votes;
    private Date createdAt;
    private User author;

    public Answer(String answer, Question question, User author) {
        this.id = answerCounter++;
        this.answer = answer;
        this.question = question;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.createdAt = new Date();
        this.author = author;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void addVote(User user, int value) {
        votes.removeIf(vote -> vote.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value * 10);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }
}
