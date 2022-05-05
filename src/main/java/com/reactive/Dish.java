package com.reactive;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Dish {
    private final String name;
    private boolean isDelivery;

    public Dish deliver() {
        return new Dish(name, true);
    }

    public Dish(final String name) {
        this.name = name;
        this.isDelivery = false;
    }

    public Dish(final String name, final boolean isDelivery) {
        this.name = name;
        this.isDelivery = isDelivery;
    }
}
