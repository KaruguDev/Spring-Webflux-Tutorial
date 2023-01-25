package com.spring.webflux.tutorial.webfluxtutorial.models;

import lombok.*;

@Data
@AllArgsConstructor
@Getter @Setter @ToString
public class Order {
    private Long id;
    private Integer amount;
    public Order(){}

}
