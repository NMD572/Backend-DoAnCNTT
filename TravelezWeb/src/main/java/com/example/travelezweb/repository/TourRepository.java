package com.example.travelezweb.repository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository  extends JpaRepository<Tour, Integer> {
    Page<Tour> findAllByOrderByQualityDesc(Pageable pageable);

}
