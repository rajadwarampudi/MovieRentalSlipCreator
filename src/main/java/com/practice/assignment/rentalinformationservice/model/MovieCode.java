package com.practice.assignment.rentalinformationservice.model;

public enum MovieCode {
    CHILDREN("children"),
    NEW("new"),
    REGULAR("regular"),
    INVALID("invalid");

    private final String description;

    MovieCode(String movieCodeDescription) {
        this.description = movieCodeDescription;
    }

    public String getDescription() {
        return description;
    }

}
