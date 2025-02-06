package com.practice.assignment;

import com.practice.assignment.rentalinformationservice.model.Customer;
import com.practice.assignment.rentalinformationservice.model.MovieRentalInformation;
import com.practice.assignment.rentalinformationservice.RentalInformationGenerator;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;

import java.util.Arrays;
import java.util.logging.Logger;

public class MovieRentalSlipCreator {

    private static final Logger LOGGER = Logger.getLogger(MovieRentalSlipCreator.class.getName());

    public static void main(String[] args) {

        Customer customer = new Customer("C. U. Stomer", Arrays.asList(
                new MovieRentalInformation("F001", 3),
                new MovieRentalInformation("F002", 1)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String resultStatement = "";
        try {
            resultStatement = generator.generateStatement(customer);
        } catch (InvalidMovieInformationException e) {
            LOGGER.severe("Exception occurred: " + e.getMessage());
        }

        System.out.println(resultStatement);
    }
}