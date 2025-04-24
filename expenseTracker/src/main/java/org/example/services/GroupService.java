package org.example.services;

import org.example.models.Expense;
import org.example.models.Group;
import org.example.models.User;
import org.example.repositories.GroupRepository;

public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(String name) {
        groupRepository.save(new Group(name));
    }

    public void addUserToGroup(String id, User user) {
        Group group = groupRepository.findById(id);

        if(group == null) {
            throw new IllegalArgumentException("Invalid group Id");
        }
        group.addUser(user.getId());
    }

    public void addExpenseToGroup(String id, Expense expense) {
        Group group = groupRepository.findById(id);

        if(group == null) {
            throw new IllegalArgumentException("Invalid group Id");
        }
        group.addExpense(expense.getId());
    }


}
