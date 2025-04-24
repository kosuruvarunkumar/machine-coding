package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        return userRepository.save(new User(name, email));
    }

    public User getUser(String id) {
        return userRepository.findById(id);
    }
}
