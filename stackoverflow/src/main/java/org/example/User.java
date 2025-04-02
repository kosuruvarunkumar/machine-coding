package org.example;


import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    private static int userIdCounter = 1;
    private final int id;
    private final String name;
    private final String email;
    private int reputation;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    public User(String name, String email) {
        this.id = userIdCounter++;
        this.name = name;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String description, List<Tag> tags) {
        Question question = new Question(title, description, this, tags);
        this.questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion (String content, Question question) {
        Answer answer = new Answer(content, question, this);
        this.answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        this.comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public synchronized void updateReputation(int value) {
        this.reputation = Math.max(this.reputation + value, 0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
}
