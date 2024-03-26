package org.javaacademy.delivery_app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(String email, String password) {
        userRepository.add(new User(email, password));
    }

    public void checkIn(String email, String password) {
        User user = userRepository.findUser(email)
                .orElseThrow(() -> new RuntimeException("Пользователя с таким email не существует:" + email));
        if (!Objects.equals(password, user.getPassword())) {
            throw new RuntimeException("Пароль некорректный");
        }
    }
}
