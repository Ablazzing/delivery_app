package org.javaacademy.delivery_app.delivery;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.delivery_app.order.OrderService;
import org.javaacademy.delivery_app.restaurant.Restaurant;
import org.javaacademy.delivery_app.restaurant.RestaurantService;
import org.javaacademy.delivery_app.user.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {
    private final RestaurantService restaurantService;
    private final UserService userService;
    private final OrderService orderService;

    public Restaurant createRestaurant(@NonNull String name) {
        return restaurantService.createRestaurant(name);
    }

    public void createFood(@NonNull String restaurantName,
                           @NonNull String foodName,
                           @NonNull String priceFood) {
        restaurantService.createFood(restaurantName, foodName, new BigDecimal(priceFood));
    }

    public void createUser(@NonNull String email, @NonNull String password) {
        userService.createUser(email, password);
    }

    public void takeOrder(String userEmail,
                       String password,
                       String restaurantName,
                       List<String> foodList) {
        BigDecimal result = orderService.takeOrder(userEmail, password, restaurantName, foodList);
        log.info("Заказ вам будет стоить: " + result);
    }
}
