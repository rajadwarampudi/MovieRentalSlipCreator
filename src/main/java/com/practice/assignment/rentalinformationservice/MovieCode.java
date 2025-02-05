package com.practice.assignment.rentalinformationservice;

public enum MovieCode {
    CHILDREN("childrens"),
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
