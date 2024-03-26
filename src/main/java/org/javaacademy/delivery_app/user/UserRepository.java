package org.javaacademy.delivery_app.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getEmail(), user);
    }

    public Optional<User> findUser(String email) {
        return Optional.ofNullable(users.get(email));
    }
}
