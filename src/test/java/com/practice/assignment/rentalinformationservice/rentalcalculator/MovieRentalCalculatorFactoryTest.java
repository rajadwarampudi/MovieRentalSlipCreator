package com.practice.assignment.rentalinformationservice.rentalcalculator;

import com.practice.assignment.rentalinformationservice.model.MovieCode;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRentalCalculatorFactoryTest {

    private final MovieRentalCalculatorFactory factory = new MovieRentalCalculatorFactory();

    @Test
    public void testNewMovieRentalCalculatorCreation() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.NEW, 5);

        assertNotNull(calculator);
        assertInstanceOf(NewMovieRentalCalculator.class, calculator);
    }


    @Test
    public void testRegularMovieRentalCalculatorCreation() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.REGULAR, 5);

        assertNotNull(calculator);
        assertInstanceOf(RegularMovieRentalCalculator.class, calculator);
    }

    @Test
    public void testChildrenMovieRentalCalculatorCreation() throws InvalidMovieInformationException {
        MovieRentalCalculator calculator = factory.getMovieRentalCalculator(MovieCode.CHILDREN, 5);

        assertNotNull(calculator);
        assertInstanceOf(ChildrensMovieRentalCalculator.class, calculator);
    }

    @Test
    void testInvalidMovieCodeThrowsException() {
        InvalidMovieInformationException exception = assertThrows(InvalidMovieInformationException.class, () -> {
            factory.getMovieRentalCalculator(MovieCode.INVALID, 4);
        });

        assertEquals("Moviecode: INVALID: invalid is not supported", exception.getMessage());
    }

}
