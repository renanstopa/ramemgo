package com.api.ramemgo.interceptors;

import com.api.ramemgo.dtos.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String X_API_KEY = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xApiKey = request.getHeader("x-api-key");

        if(xApiKey.isEmpty())
            returnError(HttpServletResponse.SC_FORBIDDEN, "x-api-key header missing", response);

        if(!xApiKey.equals(X_API_KEY))
            returnError(HttpServletResponse.SC_UNAUTHORIZED, "invalid x-api-key", response);

        return true;
    }

    private boolean returnError(int status, String messageError, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = new ErrorResponse(messageError);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        response.getWriter().write(mapper.writeValueAsString(errorResponse));

        return false;
    }

}
