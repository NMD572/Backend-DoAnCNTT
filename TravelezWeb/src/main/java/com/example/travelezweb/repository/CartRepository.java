package com.example.travelezweb.repository;

import com.example.travelezweb.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}