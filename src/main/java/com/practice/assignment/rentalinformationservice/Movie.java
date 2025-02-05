package com.practice.assignment.rentalinformationservice;

public class Movie {
    private final String title;
    private final MovieCode code;

    public Movie(String title, MovieCode code) {

        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public MovieCode getCode() {
        return code;
    }
}
