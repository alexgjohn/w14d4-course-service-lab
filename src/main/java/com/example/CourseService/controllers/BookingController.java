package com.example.CourseService.controllers;

import com.example.CourseService.models.Booking;
import com.example.CourseService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "byDate", required = false) String date
    ) {
        if (date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/bookings/{id}")
    public String deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return String.format("Booking with id %s deleted!", id);
    }
}
