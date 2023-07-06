package com.example.CourseService.models;

import java.util.ArrayList;

public class Course {

    private String name;

    private String town;

    private StarRating starRating;

//    private List<Booking> bookings;


    public Course() {
    }

    public Course(String name, String town, StarRating starRating) {
        this.name = name;
        this.town = town;
        this.starRating = starRating;
//        this.bookings = new ArrayList<Booking>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }
}
