package com.example.CourseService.controllers;

import com.example.CourseService.models.Customer;
import com.example.CourseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "byBookingsCourseId", required = false) Long courseId
    ){
        if (courseId != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }


}
