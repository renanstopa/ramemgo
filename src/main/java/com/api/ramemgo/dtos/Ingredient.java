package com.api.ramemgo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private double price;

}
