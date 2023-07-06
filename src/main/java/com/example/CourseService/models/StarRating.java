package com.example.CourseService.models;

public enum StarRating {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int stars;

    StarRating(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }
}
