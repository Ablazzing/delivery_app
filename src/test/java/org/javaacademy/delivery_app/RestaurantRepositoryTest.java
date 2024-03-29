package org.javaacademy.delivery_app;

import org.javaacademy.delivery_app.restaurant.Restaurant;
import org.javaacademy.delivery_app.restaurant.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RestaurantRepositoryTest {
    @Autowired
    private RestaurantRepository restaurantRepository;

//    @BeforeEach
//    void init() {
//        restaurantRepository.deleteAll();
//    }

    @Test
    void addSuccess() {
        restaurantRepository.add(new Restaurant("test"));
        List<Restaurant> restaurants = restaurantRepository.findAll();
        assertEquals(1, restaurants.size());
        assertEquals("test", restaurants.get(0).getName());
    }

    @Test
    void findByNameSuccess() {
        restaurantRepository.add(new Restaurant("test"));
        Restaurant restaurant = restaurantRepository.findByName("test").orElseThrow();
        assertEquals("test", restaurant.getName());
    }

    @Test
    void findAllSuccess() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        assertEquals(0, restaurants.size());
    }
}
