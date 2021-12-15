package com.example.travelezweb.controller;

import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.model.Country;
import com.example.travelezweb.model.Tour;
import com.example.travelezweb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class CountryController {
    @Autowired
    CountryRepository countryRepository;
    //Đăng
    @RequestMapping(value = "/country/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Page<Country>> getReviewForHomePage() {
        try
        {
            int page=0;
            Page<Country> countryData = countryRepository.findAll(PageRequest.of(page, HomePageConstant.limitCountry));

            if (!countryData.isEmpty()) {
                return new ResponseEntity<Page<Country>>(countryData,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
