package com.api.ramemgo.exceptions;

public class InvalidOrder extends RuntimeException {

    public InvalidOrder(String message){
        super(message);
    }

    public InvalidOrder(String message, Throwable cause){
        super(message, cause);
    }

}
