package com.example.travelezweb.controller;

import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.model.TourGuide;
import com.example.travelezweb.repository.TourGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TourGuideController {
    @Autowired
    TourGuideRepository tourGuideRepository;

    //Đăng
    @RequestMapping(value = "/tourguide/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Page<TourGuide>> getReviewForHomePage() {
        try
        {
            //Lấy các phần tử đầu tiên nên page = 0
            int page=0;
            Page<TourGuide> tourData = tourGuideRepository.findAllByOrderByQualityDesc(PageRequest.of(page, HomePageConstant.limitTourGuide));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/tourguide/get/{id}", method = RequestMethod.GET)
    public ResponseEntity< Optional<TourGuide>> getGID(@PathVariable("id") int id) {
        try
        {

            Optional<TourGuide> tourData = tourGuideRepository.findById(id);

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
