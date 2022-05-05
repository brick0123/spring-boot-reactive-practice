package com.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class KitchenService {

    private static final List<Dish> MENU = List.of(
        new Dish("chicken"),
        new Dish("pizza"),
        new Dish("pasta")
    );

    public Flux<Dish> getDishes() {
        return Flux.<Dish>generate(sink -> sink.next(randomDish()))
            .delayElements(Duration.ofMillis(250));
    }

    private Dish randomDish() {
        return MENU.get(generateRandomIndex());
    }

    private int generateRandomIndex() {
        return ThreadLocalRandom.current().nextInt(0, MENU.size());
    }

}
