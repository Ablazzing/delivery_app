package org.javaacademy.delivery_app.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.delivery_app.restaurant.Food;
import org.javaacademy.delivery_app.restaurant.Restaurant;
import org.javaacademy.delivery_app.restaurant.RestaurantService;
import org.javaacademy.delivery_app.user.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final UserService userService;
    private final RestaurantService restaurantService;

    public BigDecimal takeOrder(String userEmail,
                                String password,
                                String restaurantName,
                                List<String> foodList) {
        userService.checkIn(userEmail, password);
        Restaurant restaurant = restaurantService.findRestaurantByName(restaurantName);
        Map<String, BigDecimal> foodPrice = restaurant.getMenu().stream()
                .collect(Collectors.toMap(Food::getName, Food::getPrice));
        foodList.stream().filter(food -> !foodPrice.containsKey(food))
                .forEach(food -> log.warn("Такой еды нет в ресторане: " + food));
        return foodList.stream().filter(foodPrice::containsKey)
                .map(foodPrice::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
