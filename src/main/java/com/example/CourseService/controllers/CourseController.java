package com.example.CourseService.controllers;

import com.example.CourseService.models.Course;
import com.example.CourseService.models.StarRating;
import com.example.CourseService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "byStarRating", required = false)StarRating starRating,
            @RequestParam(name = "byBookingsCustomerId", required = false) Long customerId
    ){
        if (starRating != null){
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        if (customerId != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }

    }
}
