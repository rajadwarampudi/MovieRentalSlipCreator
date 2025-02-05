package com.practice.assignment.rentalinformationservice;

import java.util.List;

public class Customer {
    private final String name;
    private final List<MovieRentalInformation> rentals;

    public Customer(String name, List<MovieRentalInformation> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public List<MovieRentalInformation> getRentalInformation() {
        return rentals;
    }
}
