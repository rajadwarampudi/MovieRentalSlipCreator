package com.practice.assignment.rentalinformationservice;

public class MovieRentalInformation {
    private final String movieId;
    private final int days;

    public MovieRentalInformation(String movieId, int days) {
        this.movieId = movieId;
        this.days = days;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getDays() {
        return days;
    }
}
