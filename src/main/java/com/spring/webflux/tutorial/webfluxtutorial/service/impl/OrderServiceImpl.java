package com.spring.webflux.tutorial.webfluxtutorial.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.webflux.tutorial.webfluxtutorial.models.Order;
import com.spring.webflux.tutorial.webfluxtutorial.service.OrderService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    public Flux<Order> getOrderFlux() {
        //read json file
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Order>> typeReference = new TypeReference<List<Order>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/order.json");

        try {
            List<Order> orders = mapper.readValue(inputStream, typeReference);
            return Flux.fromIterable(orders);

        }catch (IOException err){
            return Flux.empty();
        }

    }
}
