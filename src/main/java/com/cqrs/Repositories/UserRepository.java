package main.java.com.cqrs.Repositories;

import main.java.com.cqrs.Models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private Map<String, User> store = new HashMap<>();

    public void addUser(String userId, User user) {
        store.put(userId, user);
    }

    public Optional<User> getUser(String userId) {
        User user = store.get(userId);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
