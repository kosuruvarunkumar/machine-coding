package org.example.repositories;

import org.example.models.Group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryGroupRepository implements GroupRepository {
    private final Map<String, Group> groups = new HashMap<>();

    @Override
    public void save(Group group) {
        groups.put(group.getId(), group);
    }

    @Override
    public Group findById(String id) {
        return groups.get(id);
    }

    @Override
    public List<Group> findAll() {
        return groups.values().stream().toList();
    }
}
