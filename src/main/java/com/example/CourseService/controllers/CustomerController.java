package com.example.CourseService.controllers;

import com.example.CourseService.models.Customer;
import com.example.CourseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "byBookingsCourseId", required = false) Long courseId,
            @RequestParam(name = "byTown", required = false) String town,
            @RequestParam(name = "byAgeGreaterThan", required = false) Integer age
    ){
        if (town != null && courseId != null && age != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseIdAndTownAndAgeGreaterThan(courseId, town, age), HttpStatus.OK);
        }
        if (town != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseIdAndTown(courseId, town), HttpStatus.OK);
        }
        if (age != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThan(age), HttpStatus.OK);
        }
        if (courseId != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        if (town != null) {
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCase(town), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/customers/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return String.format("Customer with id %s deleted!", id);
    }


}
