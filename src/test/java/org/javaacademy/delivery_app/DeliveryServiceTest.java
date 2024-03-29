package org.javaacademy.delivery_app;

import org.javaacademy.delivery_app.delivery.DeliveryService;
import org.javaacademy.delivery_app.order.OrderService;
import org.javaacademy.delivery_app.restaurant.RestaurantService;
import org.javaacademy.delivery_app.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("china")
public class DeliveryServiceTest {
    @Autowired
    private DeliveryService deliveryService;
    @MockBean
    private RestaurantService restaurantService;
    @MockBean
    private OrderService orderService;
    @MockBean
    private UserService userService;

    @Test
    void createFoodSuccess() {
        assertDoesNotThrow(() -> deliveryService.createFood("", "", "0"));
    }

    @Test
    void createFoodFail() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> deliveryService.createFood("", "", "sss")
        );
    }

    @Test
    void takeOrderSuccess() {
        Mockito.when(orderService.takeOrder(any(), any(), any(), any())).thenReturn(BigDecimal.valueOf(100));
        BigDecimal result = deliveryService.takeOrder("", "", "", null);
        Assertions.assertEquals(BigDecimal.valueOf(100), result);
    }
}
