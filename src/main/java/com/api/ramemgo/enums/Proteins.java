package com.api.ramemgo.enums;

import com.api.ramemgo.exceptions.InvalidOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Proteins {

    CHASU("1", "https://tech.redventures.com.br/icons/pork/inactive.svg", "https://tech.redventures.com.br/icons/pork/inactive.svg",
            "Chasu", "A sliced flavourful pork meat with a selection of season vegetables.", 10.0),
    CHICKEN("2", "https://tech.redventures.com.br/icons/chicken/inactive.svg", "https://tech.redventures.com.br/icons/chicken/inactive.svg",
            "Chicken", "A delicious meat.", 20.0);

    private final String id;
    private final String imageInactive;
    private final String imageActive;
    private final String name;
    private final String description;
    private final double price;

    public static Proteins getById(String id){
        for (Proteins p : values()){
            if(p.getId().equals(id))
                return p;
        }

        throw new InvalidOrder("invalid proteinId");
    }

}
