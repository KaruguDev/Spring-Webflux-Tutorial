package com.spring.webflux.tutorial.webfluxtutorial.service;

import com.spring.webflux.tutorial.webfluxtutorial.models.Order;
import com.spring.webflux.tutorial.webfluxtutorial.service.impl.OrderServiceImpl;
import reactor.core.publisher.Flux;

import java.io.IOException;

public interface OrderService {

    Flux<Order> getOrderFlux() throws IOException;
}
