package com.api.ramemgo.interceptors;

import com.api.ramemgo.exceptions.ApiKeyMissing;
import com.api.ramemgo.exceptions.ApiKeyWrong;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String X_API_KEY = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xApiKey = request.getHeader("x-api-key");

         if(xApiKey == null || xApiKey.isEmpty())
            throw new ApiKeyMissing("x-api-key header missing");

        if(!xApiKey.equals(X_API_KEY))
            throw new ApiKeyWrong("invalid x-api-key");

        return true;
    }

}
