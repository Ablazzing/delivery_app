package org.javaacademy.delivery_app;

import org.javaacademy.delivery_app.delivery.DeliveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DeliveryAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DeliveryAppApplication.class, args);
		DeliveryService deliveryService = context.getBean(DeliveryService.class);

	}

}
