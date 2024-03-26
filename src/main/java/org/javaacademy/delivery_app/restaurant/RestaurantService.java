package org.javaacademy.delivery_app.restaurant;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(@NonNull String name) {
        return new Restaurant(name);
    }

    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findByName(name).orElseThrow();
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public void createFood(String restaurantName, String foodName, BigDecimal priceFood) {
        Restaurant restaurant = findRestaurantByName(restaurantName);
        restaurant.getMenu().add(new Food(foodName, priceFood));
    }
}
