package com.example.travelezweb.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.Tour;
public interface TourRepository  extends JpaRepository<Tour, Integer> {

}
