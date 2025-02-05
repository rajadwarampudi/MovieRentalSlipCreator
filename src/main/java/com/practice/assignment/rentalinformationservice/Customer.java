package com.practice.assignment.rentalinformationservice;

import java.util.List;

public record Customer(String name, List<MovieRentalInformation> rentals) {
}
