package org.javaacademy.delivery_app.restaurant;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class RestaurantRepository {
    private final Map<String, Restaurant> restaurants = new LinkedHashMap<>();

    public void add(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public Optional<Restaurant> findByName(String name) {
        return Optional.ofNullable(restaurants.get(name));
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants.values());
    }

}
