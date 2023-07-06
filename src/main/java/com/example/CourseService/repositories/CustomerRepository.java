package com.example.CourseService.repositories;

import com.example.CourseService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long courseId);

    List<Customer> findByBookingsCourseIdAndTown(Long courseId, String town);

    List<Customer> findByTownIgnoreCase(String town);

    List<Customer> findByAgeGreaterThan(Integer age);

    List<Customer> findByBookingsCourseIdAndTownAndAgeGreaterThan(Long courseId, String town, Integer age);
}
