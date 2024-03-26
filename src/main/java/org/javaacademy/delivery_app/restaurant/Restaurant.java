package org.javaacademy.delivery_app.restaurant;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Restaurant {
    @NonNull
    @Setter
    private String name;
    private final Set<Food> menu = new HashSet<>();


}
