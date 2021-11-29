package com.example.travelezweb.controller;

import com.example.travelezweb.model.Cart;
import com.example.travelezweb.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @PostMapping(value="/cart")
    public ResponseEntity<Map<String, Object>> createTour(@RequestBody Cart cart) {
        Map<String, Object> mapResult=new HashMap<>();
        mapResult.put("status", false);
        try {
            Cart newcart = cartRepository
                    .save(new Cart(cart.getStatus(),cart.getUserincart(),cart.getTourincart()));
            mapResult.put("newcart",newcart);
            mapResult.remove("status");
            mapResult.put("status", true);
        } catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally
        {
            return new ResponseEntity<Map<String, Object>>(mapResult, HttpStatus.CREATED);
        }
    }
}
