package com.example.travelezweb.controller;

import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.constant.SearchTourConstant;
import com.example.travelezweb.model.Tour;
import com.example.travelezweb.model.TourGuide;
import com.example.travelezweb.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SearchTourController {
    @Autowired
    TourRepository tourRepository;
    @RequestMapping(value = "/tours/searchByTourguide/{page}", method = RequestMethod.POST)
    public ResponseEntity<Page<Tour>> getTourByTourguideName(@PathVariable("page")  int page,  @RequestBody Map<String, String> json) {
        try {
            //Lấy các phần tử đầu tiên nên page = 0
            String searchString=json.get("searchString");
            Page<Tour> tourData = tourRepository.findAllByTourguideName(searchString,PageRequest.of(page, SearchTourConstant.itemInSearch));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/tours/searchByTour/{page}", method = RequestMethod.POST)
    public ResponseEntity<Page<Tour>> getTourByName(@PathVariable("page")  int page, @RequestBody Map<String, String> json) {
        try {
            //Lấy các phần tử đầu tiên nên page = 0
            String searchString=json.get("searchString");
            Page<Tour> tourData = tourRepository.findAllByName(searchString,PageRequest.of(page, SearchTourConstant.itemInSearch));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/tours/searchAll/{page}", method = RequestMethod.POST)
    public ResponseEntity<Page<Tour>> getAllTour(@PathVariable("page")  int page, @RequestBody Map<String, String> json) {
        try {
            //Lấy các phần tử đầu tiên nên page = 0
            String searchString=json.get("searchString");
            Page<Tour> tourData = tourRepository.findAll(searchString,PageRequest.of(page, SearchTourConstant.itemInSearch));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
