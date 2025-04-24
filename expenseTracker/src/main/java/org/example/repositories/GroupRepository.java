package org.example.repositories;

import org.example.models.Group;

import java.util.List;

public interface GroupRepository {
    void save(Group group);
    Group findById(String id);
    List<Group> findAll();
}
