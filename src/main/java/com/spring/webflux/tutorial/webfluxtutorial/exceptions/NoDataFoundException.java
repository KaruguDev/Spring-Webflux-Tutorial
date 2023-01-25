package com.spring.webflux.tutorial.webfluxtutorial.exceptions;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {

        super("No data found");
    }

}
