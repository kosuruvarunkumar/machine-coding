package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverFlow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverFlow() {
        this.users = new HashMap<>();
        this.questions = new HashMap<>();
        this.answers = new HashMap<>();
        this.tags = new HashMap<>();
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(String title, String description, User user, List<String> tagNames) {
        List<Tag> questionTags = new ArrayList<>();
        for(String tagName : tagNames) {
            questionTags.add(tags.getOrDefault(tagName, new Tag(tagName)));
        }
        Question question = user.askQuestion(title, description, questionTags);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer answerQuestion(String content, Question question, User user) {
        Answer answer = user.answerQuestion(content, question);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(commentable, content);
    }

    public void addVote(User user, Votable votable, int value) {
        votable.addVote(user, value);
    }
}
