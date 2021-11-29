package com.example.travelezweb.repository;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.Tour;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TourRepository  extends JpaRepository<Tour, Integer> {
    Page<Tour> findAllByOrderByQualityDesc(Pageable pageable);
    //Sum all time of used tour
    @Query(value = "Select sum(t.time) From Tour t, Cart c Where c.tourincart=t and c.status='done'")
    long sumtotaltimeofusedtour();
    @Query(value ="Select min(t.price) From Tour t")
    double getminpriceofalltour();
    @Query(value ="Select avg(t.quality) From Tour t")
    double getavgqualityofalltour();
    @Query(value ="Select count(*) From Tour t")
    long countAll();
}
