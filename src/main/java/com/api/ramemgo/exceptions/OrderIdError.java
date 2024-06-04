package com.api.ramemgo.exceptions;

public class OrderIdError extends RuntimeException {

    public OrderIdError(String message){
        super(message);
    }

    public OrderIdError(String message, Throwable cause){
        super(message, cause);
    }
}
