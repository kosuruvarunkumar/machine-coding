package org.example.repositories;

import org.example.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }
}
