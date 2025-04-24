package org.example.repositories;

import org.example.models.User;

import java.util.List;

public interface UserRepository {
    User findById(String id);
    User save(User user);
    List<User> findAll();
}
