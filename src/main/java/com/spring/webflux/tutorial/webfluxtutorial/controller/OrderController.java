package com.spring.webflux.tutorial.webfluxtutorial.controller;

import com.spring.webflux.tutorial.webfluxtutorial.exceptions.NoDataFoundException;
import com.spring.webflux.tutorial.webfluxtutorial.exceptions.OrderNotFoundException;
import com.spring.webflux.tutorial.webfluxtutorial.models.Order;
import com.spring.webflux.tutorial.webfluxtutorial.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-all")
    public Flux<Order> getAllOrders() throws IOException {
        Flux<Order> orderFlux = orderService.getOrderFlux();

        Mono<Order> orderMono = orderFlux.next().switchIfEmpty(Mono.empty());
        if(orderMono.blockOptional().isPresent()){
            orderFlux.subscribe();
            return orderFlux;
        }

        throw new NoDataFoundException();
    }

    @GetMapping("/{orderId}")
    public Mono<Order> getOrder(@PathVariable("orderId") Long orderId) throws IOException {
        Flux<Order> orderFlux = orderService.getOrderFlux();
        Flux<Order> filteredOrderFlux = orderFlux.filter(order -> order.getId() == orderId);

        Mono<Order> orderMono = filteredOrderFlux.singleOrEmpty();
        orderMono.subscribe();

        if (orderMono.blockOptional().isPresent()) {
            return orderMono;
        }
        throw new OrderNotFoundException(orderId);

    }
}
