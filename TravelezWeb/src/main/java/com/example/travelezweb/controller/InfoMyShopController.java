package com.example.travelezweb.controller;

import com.example.travelezweb.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InfoMyShopController {
    @Autowired
    TourRepository tourRepository;
    //Đăng
    @RequestMapping(value = "/infomyshop/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getReviewForHomePage() {
        try
        {
            Map<String,Object> mapVal=new HashMap<>();
            long numberoftour = tourRepository.countAll();
            long totaltimeofallusedtour=tourRepository.sumtotaltimeofusedtour();
            double minpriceoftour=tourRepository.getminpriceofalltour();
            double averagequalityofalltour=tourRepository.getavgqualityofalltour();
            mapVal.put("numberoftour",numberoftour);
            mapVal.put("totaltime",totaltimeofallusedtour);
            mapVal.put("minprice",minpriceoftour);
            mapVal.put("averagequality",averagequalityofalltour);
            return new ResponseEntity<Map<String,Object>>(mapVal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
