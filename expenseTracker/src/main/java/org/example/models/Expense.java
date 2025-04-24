package org.example.models;

import java.util.Map;
import java.util.UUID;

public class Expense {
    private final String id;
    private final String groupId;
    private final String paidBy;
    private final double amount;
    private final String description;
    private final Map<String, Double> splits;

    public Expense(String groupId, String paidBy, double amount, String description, Map<String, Double> splits) {
        this.id = "E-" + UUID.randomUUID().toString();
        this.groupId = groupId;
        this.paidBy = paidBy;
        this.amount = amount;
        this.description = description;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getSplits() {
        return splits;
    }
}
