package org.example.models;

import java.util.*;

public class Group {
    private final String id;
    private final String name;
    private final Set<String> userIds;
    private final List<String> expenseIds;

    public Group(String name) {
        this.id = "G-" + UUID.randomUUID().toString();
        this.name = name;
        this.userIds = new HashSet<>();
        this.expenseIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUserIds() {
        return userIds;
    }

    public List<String> getExpenseIds() {
        return expenseIds;
    }

    public void addUser(String userId) {
        userIds.add(userId);
    }

    public void addExpense(String expenseId) {
        expenseIds.add(expenseId);
    }
}
