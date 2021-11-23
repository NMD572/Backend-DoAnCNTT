package com.example.travelezweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.travelezweb.model.Tour;
import com.example.travelezweb.repository.TourRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TourController {
    final
    TourRepository tourRepository;
    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @PostMapping("/tours")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        try {
            Tour _tour = tourRepository
                    .save(new Tour( tour.getName(), tour.getBrief(), tour.getDescription(), tour.getPrice(),
                            tour.getQuality(), tour.getIdtourguy(), tour.getMaxmember(), tour.getCountry(), tour.getTime()));
            return new ResponseEntity<>(_tour, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tours/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable("id") long id, @RequestBody Tour tour) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (tourData.isPresent()) {
            Tour _tour = tourData.get();
            _tour.setName(tour.getName());
            _tour.setBrief(tour.getBrief());
            _tour.setDescription(tour.getDescription());
            _tour.setPrice(tour.getPrice());
            _tour.setQuality(tour.getQuality());
            _tour.setIdtourguy(tour.getIdtourguy());
            _tour.setMaxmember(tour.getMaxmember());
            _tour.setCountry(tour.getCountry());
            _tour.setTime(tour.getTime());
            return new ResponseEntity<>(tourRepository.save(_tour), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tours/{id}")
    public ResponseEntity<HttpStatus> deleteTour(@PathVariable("id") long id) {
        try {
            tourRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tours/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") long id) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (tourData.isPresent()) {
            return new ResponseEntity<>(tourData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

