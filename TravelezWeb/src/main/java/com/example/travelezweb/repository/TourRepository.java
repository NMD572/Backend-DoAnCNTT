package com.example.travelezweb.repository;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.Tour;

public interface TourRepository  extends JpaRepository<Tour, Integer> {
    Page<Tour> findAllByOrderByQualityDesc(Pageable pageable);

}
