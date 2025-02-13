package com.practice.assignment.rentalinformationservice;

import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import com.practice.assignment.rentalinformationservice.model.Customer;
import com.practice.assignment.rentalinformationservice.model.MovieRentalInformation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RentalInformationGeneratorTest {

    @Test
    public void testStatementGeneration() throws InvalidMovieInformationException {
        String expectedStatement = """
                Rental Record for C. U. Stomer
                \tYou've Got Mail\t3.5
                \tMatrix\t2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;

        Customer customer = new Customer("C. U. Stomer", List.of(
                new MovieRentalInformation("F001", 3),
                new MovieRentalInformation("F002", 1)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String result = generator.generateStatement(customer);

        assertEquals(expectedStatement, result, "The rental statement was not as expected");
    }

    @Test
    public void testStatementGenerationWithUnknownMovieId() {
        Customer customer = new Customer("C. U. Stomer", List.of(
                new MovieRentalInformation("F001", 3),
                new MovieRentalInformation("F022", 1)));

        assertThrows(InvalidMovieInformationException.class, () -> {
            RentalInformationGenerator generator = new RentalInformationGenerator();
            generator.generateStatement(customer);
        });
    }


    @Test
    public void testStatementGenerationWithLongRentalDays() throws InvalidMovieInformationException {
        String expectedStatement = """
                Rental Record for John smith
                \tYou've Got Mail\t23.0
                \tMatrix\t29.0
                \tCars\t24.0
                \tFast & Furious X\t60.0
                Amount owed is 136.0
                You earned 5 frequent points
                """;

        Customer customer = new Customer("John smith", List.of(
                new MovieRentalInformation("F001", 16),
                new MovieRentalInformation("F002", 20),
                new MovieRentalInformation("F003", 18),
                new MovieRentalInformation("F004", 20)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String result = generator.generateStatement(customer);

        assertEquals(expectedStatement, result, "The rental statement was not as expected");
    }

    @Test
    public void testStatementGenerationWithOneDayRentalDays() throws InvalidMovieInformationException {
        String expectedStatement = """
                Rental Record for Thomas håkansson
                \tYou've Got Mail\t2.0
                \tMatrix\t2.0
                \tCars\t1.5
                \tFast & Furious X\t3.0
                Amount owed is 8.5
                You earned 4 frequent points
                """;

        Customer customer = new Customer("Thomas håkansson", List.of(
                new MovieRentalInformation("F001", 1),
                new MovieRentalInformation("F002", 1),
                new MovieRentalInformation("F003", 1),
                new MovieRentalInformation("F004", 1)));

        RentalInformationGenerator generator = new RentalInformationGenerator();
        String result = generator.generateStatement(customer);

        assertEquals(expectedStatement, result, "The rental statement was not as expected");
    }
}
