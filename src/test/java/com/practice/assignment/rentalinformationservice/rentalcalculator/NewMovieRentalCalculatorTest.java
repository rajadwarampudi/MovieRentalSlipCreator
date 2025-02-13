package com.practice.assignment.rentalinformationservice.rentalcalculator;

import com.practice.assignment.rentalinformationservice.model.MovieCode;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewMovieRentalCalculatorTest {

    private final MovieRentalCalculatorFactory factory = new MovieRentalCalculatorFactory();

    @Test
    public void testCalculationOfRentalAndBonusPointsForOneDay() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.NEW, 1);

        assertEquals(1.0, calculator.calculateRent());
        assertEquals(3, calculator.calculateBonusPoints());
    }


    @Test
    public void testCalculationOfRentalAndBonusPointsForMultipleDays() throws InvalidMovieInformationException {
        Random random = new Random();
        int noOfDays = random.nextInt(2, 500);
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.NEW, noOfDays);

        assertEquals(noOfDays * 3.0, calculator.calculateRent());
        assertEquals(2, calculator.calculateBonusPoints());
    }

}
