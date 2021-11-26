package com.example.travelezweb.repository;

import com.example.travelezweb.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}