package com.api.ramemgo.dtos;

import lombok.Data;

@Data
public class IngredientDto {

    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private double price;

}
