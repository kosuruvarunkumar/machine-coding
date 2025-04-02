package org.example;

public interface Votable {
    void addVote(User user, int value);
    int getVoteCount();
}
