package com.practice.assignment.rentalinformationservice.model;

import java.util.List;

public record Customer(String name, List<MovieRentalInformation> rentals) {
}
