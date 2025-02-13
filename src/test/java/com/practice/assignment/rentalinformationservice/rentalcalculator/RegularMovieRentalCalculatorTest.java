package com.practice.assignment.rentalinformationservice.rentalcalculator;

import com.practice.assignment.rentalinformationservice.model.MovieCode;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularMovieRentalCalculatorTest {

    private final MovieRentalCalculatorFactory factory = new MovieRentalCalculatorFactory();

    @Test
    public void testCalculationOfRentalAndBonusPointsExactDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.REGULAR, 2);

        assertEquals(2.0, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }

    @Test
    public void testCalculationOfRentalAndBonusPointsLessThanDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.REGULAR, 1);

        assertEquals(2.0, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }

    @Test
    public void testBasicCalculationOfRentalAndBonusPointsMoreThanDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.REGULAR, 89);

        assertEquals(132.5, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }
}
