package com.api.ramemgo.dtos;

import com.api.ramemgo.enums.Broths;
import com.api.ramemgo.enums.Proteins;
import lombok.Data;

@Data
public class OrderResponse {

    private String id;
    private String description;
    private String image;

    public OrderResponse(String orderId, Broths broth, Proteins protein) {
        this.id = orderId;
        this.description = broth.getName() + " and " + protein.getName() + " Ramen";
        this.image = "https://tech.redventures.com.br/icons/ramen/ramenChasu.png";
    }
}
