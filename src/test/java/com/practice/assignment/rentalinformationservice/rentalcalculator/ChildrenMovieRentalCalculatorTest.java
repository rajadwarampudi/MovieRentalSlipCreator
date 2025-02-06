package com.practice.assignment.rentalinformationservice.rentalcalculator;

import com.practice.assignment.rentalinformationservice.MovieCode;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChildrenMovieRentalCalculatorTest {

    private final MovieRentalCalculatorFactory factory = new MovieRentalCalculatorFactory();

    @Test
    public void testCalculationOfRentalAndBonusPointsExactDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.CHILDREN, 3);

        assertEquals(1.5, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }

    @Test
    public void testCalculationOfRentalAndBonusPointsLessThanDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.CHILDREN, 2);

        assertEquals(1.5, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }

    @Test
    public void testBasicCalculationOfRentalAndBonusPointsMoreThanDefaultDays() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.CHILDREN, 89);

        assertEquals(130.5, calculator.calculateRent());
        assertEquals(1, calculator.calculateBonusPoints());
    }
}
