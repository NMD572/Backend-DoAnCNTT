package com.example.travelezweb.controller;

import com.example.travelezweb.constant.CartConstant;
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
    //@RequestMapping(value = "/infomyshop/view-homepage", method = RequestMethod.GET)
    @RequestMapping(value="/cart", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createCart(@RequestBody Cart cart) {
        Map<String, Object> mapResult=new HashMap<>();
        mapResult.put("status", false);
        try {
            Cart newcart = cartRepository
                    .save(new Cart(cart.getStatus(),cart.getUserincart(),cart.getTourincart()));
            mapResult.put("newcart",newcart);
            mapResult.remove("status");
            mapResult.put("status", true);
            return new ResponseEntity<Map<String, Object>>(mapResult, HttpStatus.CREATED);
        } catch (Exception e)
        {
            return new ResponseEntity<Map<String, Object>>(mapResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //@PostMapping(value="/cart/check-exit")
    @RequestMapping(value="/cart/check-exit", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> checkCartExist(@RequestBody Cart cart) {
        Map<String, Object> mapResult=new HashMap<>();
        mapResult.put("status", true);
        try {
            int checktouravailable=cartRepository.countByTourincartAndStatusOrStatus(cart.getTourincart(),CartConstant.process,CartConstant.waittocheck);
            if(checktouravailable==0)
            {
                int countcartexist = cartRepository.countByStatusAndUserincartAndTourincart(CartConstant.incart, cart.getUserincart(), cart.getTourincart());
                if (countcartexist == 0)
                {
                    mapResult.remove("status");
                    mapResult.put("status", false);
                }
                else
                {
                    mapResult.put("alert","This tour have already in your cart!");
                }
            }
            else
            {
                mapResult.put("alert","This tour is in use!");
            }
            return new ResponseEntity<Map<String, Object>>(mapResult, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
