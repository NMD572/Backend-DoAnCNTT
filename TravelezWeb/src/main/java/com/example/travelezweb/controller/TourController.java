package com.example.travelezweb.controller;


import java.util.Optional;

import com.example.travelezweb.constant.HomePageConstant;
import com.example.travelezweb.model.TourGuide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(value="/tours")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        try {
            Tour _tour = tourRepository
                    .save(new Tour( tour.getName(), tour.getBrief(), tour.getDescription(), tour.getPrice(),
                            tour.getQuality(), tour.getTourguide(), tour.getMaxmember(), tour.getCountry(), tour.getTime(),tour.getAction(),tour.getImage()));
            return new ResponseEntity<>(_tour, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tours/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable("id") int id, @RequestBody Tour tour) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (tourData.isPresent()) {
            Tour _tour = tourData.get();
            _tour.setName(tour.getName());
            _tour.setBrief(tour.getBrief());
            _tour.setDescription(tour.getDescription());
            _tour.setPrice(tour.getPrice());
            _tour.setQuality(tour.getQuality());
            _tour.setTourguide(tour.getTourguide());
            _tour.setMaxmember(tour.getMaxmember());
            _tour.setCountry(tour.getCountry());
            _tour.setTime(tour.getTime());
            _tour.setImage(tour.getImage());
            _tour.setAction((tour.getAction()));
            return new ResponseEntity<>(tourRepository.save(_tour), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tours/{id}")
    public ResponseEntity<HttpStatus> deleteTour(@PathVariable("id") int id) {
        try {
            tourRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tours/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") int id) {
        Optional<Tour> tourData = tourRepository.findById(id);

        if (tourData.isPresent()) {
            return new ResponseEntity<>(tourData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Đăng
    @RequestMapping(value = "/tours/view-homepage", method = RequestMethod.GET)
    public ResponseEntity<Page<Tour>> getTourForHomePage() {
        try
        {
            //Lấy các phần tử đầu tiên nên page = 0
            int page=0;
            Page<Tour> tourData = tourRepository.findAllByOrderByQualityDesc(PageRequest.of(page, HomePageConstant.limitTour));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/tours/search", method = RequestMethod.POST)
    public ResponseEntity<Page<Tour>> getTourByTourguideName(@RequestBody TourGuide tourGuide) {
        try
        {
            //Lấy các phần tử đầu tiên nên page = 0
            int page=0;
            Page<Tour> tourData = tourRepository.findAllByOrderByQualityDesc(PageRequest.of(page, HomePageConstant.limitTour));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/tours/search", method = RequestMethod.PUT)
    public ResponseEntity<Page<Tour>> getTourByName(@RequestBody Tour tour) {
        try
        {
            //Lấy các phần tử đầu tiên nên page = 0
            int page=0;
            Page<Tour> tourData = tourRepository.findAllByOrderByQualityDesc(PageRequest.of(page, HomePageConstant.limitTour));

            if (!tourData.isEmpty()) {
                return new ResponseEntity<Page<Tour>>(tourData,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}