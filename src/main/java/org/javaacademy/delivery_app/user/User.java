package org.javaacademy.delivery_app.user;

import lombok.Data;
import lombok.NonNull;


@Data
public class User {
    @NonNull
    private final String email;

    @NonNull
    private String password;
}
