package com.api.ramemgo.configs;

import com.api.ramemgo.dtos.ErrorResponse;
import com.api.ramemgo.exceptions.ApiKeyMissing;
import com.api.ramemgo.exceptions.ApiKeyWrong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ApiKeyMissing.class)
    public ResponseEntity<ErrorResponse> handleApiKeyMissing(Exception ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ApiKeyWrong.class)
    public ResponseEntity<ErrorResponse> handleApiKeyWrong(Exception ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

}
