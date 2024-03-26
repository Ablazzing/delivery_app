package org.javaacademy.delivery_app.restaurant;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Food {
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
}
