package com.api.ramemgo.controllers;

import com.api.ramemgo.dtos.Ingredient;
import com.api.ramemgo.dtos.OrderRequest;
import com.api.ramemgo.dtos.OrderResponse;
import com.api.ramemgo.exceptions.InvalidOrder;
import com.api.ramemgo.services.IngredientService;
import com.api.ramemgo.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class OrderController {

    private final IngredientService ingredientService;
    private final OrderService orderService;

    @GetMapping("/broths")
    public ResponseEntity<List<Ingredient>> getBrothsList(){
        return new ResponseEntity<List<Ingredient>>(ingredientService.getBroths(), HttpStatus.OK);
    }

    @GetMapping("/proteins")
    public ResponseEntity<List<Ingredient>> getProteinsList(){
        return new ResponseEntity<List<Ingredient>>(ingredientService.getProteins(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        if(!orderRequest.isOrderValid())
            throw new InvalidOrder("both brothId and proteinId are required");

        return new ResponseEntity<OrderResponse>(orderService.order(orderRequest), HttpStatus.CREATED);
    }

}
