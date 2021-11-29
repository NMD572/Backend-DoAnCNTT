package com.example.travelezweb.repository;

import com.example.travelezweb.model.Cart;
import com.example.travelezweb.model.Tour;
import com.example.travelezweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    int countByStatusAndUserincartAndTourincart(String status, User user, Tour tour);
    int countByTourincartAndStatusOrStatus(Tour sametour, String status1, String status2);
}