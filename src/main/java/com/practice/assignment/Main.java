package com.practice.assignment;

import com.practice.assignment.rentalinformationservice.Customer;
import com.practice.assignment.rentalinformationservice.MovieRentalInformation;
import com.practice.assignment.rentalinformationservice.RentalInformationGenerator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("C. U. Stomer", Arrays.asList(
                new MovieRentalInformation("F001", 3),
                new MovieRentalInformation("F002", 1)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String resultStatement = generator.generateStatement(customer);

        System.out.println(resultStatement);
    }
}