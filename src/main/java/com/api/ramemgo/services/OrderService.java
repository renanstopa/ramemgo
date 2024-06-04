package com.api.ramemgo.services;

import com.api.ramemgo.dtos.OrderIdResponse;
import com.api.ramemgo.dtos.OrderRequest;
import com.api.ramemgo.dtos.OrderResponse;
import com.api.ramemgo.enums.Broths;
import com.api.ramemgo.enums.Proteins;
import com.api.ramemgo.exceptions.OrderIdError;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrderService {

    public OrderResponse order(OrderRequest orderRequest) {
        Broths broth = Broths.getById(orderRequest.getBrothId());
        Proteins protein = Proteins.getById(orderRequest.getProteinId());
        OrderIdResponse orderIdResponse = generateOrderId();

        return new OrderResponse(orderIdResponse.getOrderId(), broth, protein);
    }

    private OrderIdResponse generateOrderId(){
        RestClient restClient = RestClient.create();

        return restClient.post()
                .uri("https://api.tech.redventures.com.br/orders/generate-id")
                .header("x-api-key", "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf")
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new OrderIdError("could not place order");
                })
                .body(OrderIdResponse.class);
    }

}
