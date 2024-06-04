package com.api.ramemgo.dtos;

import lombok.Data;

import java.util.stream.Stream;

@Data
public class OrderRequest {

    private String brothId;
    private String proteinId;

    public boolean isOrderValid(){
        return Stream.of(brothId, proteinId).allMatch(s -> s != null && !s.isEmpty());
    }
}
