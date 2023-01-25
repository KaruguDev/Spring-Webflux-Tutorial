package com.spring.webflux.tutorial.webfluxtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.spring.webflux.tutorial.webfluxtutorial")
public class WebfluxTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxTutorialApplication.class, args);
	}

}
