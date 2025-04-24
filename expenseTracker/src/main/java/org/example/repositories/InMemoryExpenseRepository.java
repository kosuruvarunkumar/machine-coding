package org.example.repositories;

import org.example.models.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private final Map<String, Expense> expenses = new HashMap<>();
    @Override
    public void save(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    @Override
    public Expense findById(String id) {
        return expenses.get(id);
    }

    @Override
    public List<Expense> findAll() {
        return expenses.values().stream().toList();
    }
}
