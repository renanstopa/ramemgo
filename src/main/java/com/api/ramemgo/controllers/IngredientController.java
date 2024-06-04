package com.api.ramemgo.controllers;

import com.api.ramemgo.dtos.Ingredient;
import com.api.ramemgo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/broth")
    public ResponseEntity<List<Ingredient>> getBrothsList(){
        return new ResponseEntity<List<Ingredient>>(ingredientService.getBroths(), HttpStatus.OK);
    }

}
