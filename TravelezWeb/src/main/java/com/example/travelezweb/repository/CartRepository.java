package com.example.travelezweb.repository;

import com.example.travelezweb.model.Cart;
import com.example.travelezweb.model.Tour;
import com.example.travelezweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("select count(c) from Cart c where c.status = ?1 and c.userincart = ?2 and c.tourincart = ?3")
    int countByStatusAndUserincartAndTourincart(String status, User user, Tour tour);
    @Query("select count(c) from Cart c where c.tourincart = ?1 and c.status = ?2 or c.status = ?3")
    int countByTourincartAndStatusOrStatus(Tour sametour, String status1, String status2);

    @Query("select c from Cart c where c.status = ?1")
    List<Cart>  findCartByStatus(String status);

    @Query("select c from Cart c where c.userincart = ?1 and c.status = ?2")
    List<Cart>  findCartByUserincartAndStatus( User user,String status);
}