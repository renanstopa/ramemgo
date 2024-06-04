package com.api.ramemgo.services;

import com.api.ramemgo.dtos.Ingredient;
import com.api.ramemgo.enums.Broths;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    public List<Ingredient> getBroths() {
        return Arrays.stream(Broths.values())
                .map(broth -> new Ingredient(broth.getId(), broth.getImageInactive(), broth.getImageActive(), broth.getName(), broth.getDescription(), broth.getPrice()))
                .collect(Collectors.toList());
    }

}
