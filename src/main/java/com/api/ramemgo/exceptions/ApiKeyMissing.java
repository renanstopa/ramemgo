package com.api.ramemgo.exceptions;

public class ApiKeyMissing extends RuntimeException {

    public ApiKeyMissing(String message){
        super(message);
    }

    public ApiKeyMissing(String message, Throwable cause){
        super(message, cause);
    }

}
