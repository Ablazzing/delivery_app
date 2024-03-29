package org.javaacademy.delivery_app;

import org.javaacademy.delivery_app.restaurant.Restaurant;
import org.javaacademy.delivery_app.restaurant.RestaurantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DeliveryAppApplicationTests {
	@MockBean
	private RestaurantService restaurantService;

	@Test
	void contextLoads() {
		Mockito.when(restaurantService.createRestaurant(any())).thenReturn(new Restaurant("mac"));
		Restaurant mac = restaurantService.createRestaurant("mac3322");
		Assertions.assertEquals(mac.getName(), "mac");
	}

}
