package com.example.CourseService.repositories;

import com.example.CourseService.models.Course;
import com.example.CourseService.models.StarRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(StarRating starRating);

    List<Course> findByBookingsCustomerId(Long customerId);
}
