package com.example.travelezweb.repository;

import com.example.travelezweb.model.Tour;
import com.example.travelezweb.model.TourGuide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourGuideRepository extends JpaRepository<TourGuide, Integer> {
    Page<TourGuide> findAllByOrderByQualityDesc(Pageable pageable);
}