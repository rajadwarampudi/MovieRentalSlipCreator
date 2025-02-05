package com.practice.assignment.rentalinformationservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalInformationGeneratorTest {

    @Test
    public void testStatementGeneration() {
        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

        Customer customer = new Customer("C. U. Stomer", Arrays.asList(
                new MovieRentalInformation("F001", 3),
                new MovieRentalInformation("F002", 1)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String result = generator.generateStatement(customer);

        assertEquals(expected, result, "The rental statement was not as expected");
    }
}
