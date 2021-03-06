package com.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ServerController {

    private final KitchenService kitchenService;

    @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> serverDishes() {
        return kitchenService.getDishes();
    }

    @GetMapping(value = "/server-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> deliverDishes() {
        return kitchenService.getDishes()
            .map(Dish::deliver);
    }
}
