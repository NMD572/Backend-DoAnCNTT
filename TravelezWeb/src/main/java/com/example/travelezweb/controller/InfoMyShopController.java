package com.example.travelezweb.controller;

import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.model.TourGuide;
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
public class InfoMyShopController {

    //Đăng
    @RequestMapping(value = "/infomyshop/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Page<TourGuide>> getReviewForHomePage() {
        try
        {

            /*Page<TourGuide> tourData = tourGuideRepository.findAllByOrderByQualityDesc(PageRequest.of(page, HomePageConstant.limitTourGuide));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }*/
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
