package com.api.ramemgo.exceptions;

public class ApiKeyWrong extends RuntimeException {

    public ApiKeyWrong(String message){
        super(message);
    }

    public ApiKeyWrong(String message, Throwable cause){
        super(message, cause);
    }

}
