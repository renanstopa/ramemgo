package com.api.ramemgo.enums;

import com.api.ramemgo.exceptions.InvalidOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Broths {

    SALT("1", "https://tech.redventures.com.br/icons/salt/inactive.svg", "https://tech.redventures.com.br/icons/salt/active.svg",
            "Salt", "Simple like the seawater, nothing more", 10.0),
    TOMATO("2", "https://tech.redventures.com.br/icons/tomato/inactive.svg", "https://tech.redventures.com.br/icons/tomato/inactive.svg",
                   "Tomato", "A famous soup broth", 15.0);

    private final String id;
    private final String imageInactive;
    private final String imageActive;
    private final String name;
    private final String description;
    private final double price;

    public static Broths getById(String id){
        for (Broths b : values()){
            if(b.getId().equals(id))
                return b;
        }

        throw new InvalidOrder("invalid brothId");
    }

}
