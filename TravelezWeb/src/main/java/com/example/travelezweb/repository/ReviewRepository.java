package com.example.travelezweb.repository;

import com.example.travelezweb.myinterface.IReviewTour;
import com.example.travelezweb.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "Select t.name as tourname, u.fullname as userfullname, u.image as userimage, r.description as reviewdescription, r.quality as reviewquality From User u, Review r, Tour t Where r.user=u and r.tour= t Order by r.quality desc")
    Page<IReviewTour> findReviewForHomePage(Pageable pageable);
}