package org.example.repositories;

import org.example.models.Expense;

import java.util.List;

public interface ExpenseRepository {
    void save(Expense expense);
    Expense findById(String id);
    List<Expense> findAll();
}
