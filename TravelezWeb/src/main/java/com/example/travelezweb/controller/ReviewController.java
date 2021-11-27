package com.example.travelezweb.controller;

import com.example.travelezweb.myinterface.IReviewTour;
import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ReviewController
{
    @Autowired
    ReviewRepository reviewRepository;


    //Đăng
    @RequestMapping(value = "/review/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Page<IReviewTour>> getReviewForHomePage() {
        try
        {
            //Lấy các phần tử đầu tiên nên page = 0
            int page=0;
            Page<IReviewTour> tourData = reviewRepository.findReviewForHomePage(PageRequest.of(page, HomePageConstant.limitReview));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
