package com.practice.assignment.rentalinformationservice.rentalcalculator;

import com.practice.assignment.rentalinformationservice.model.MovieCode;
import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;

public class MovieRentalCalculatorFactory {
    public MovieRentalCalculator getMovieRentalCalculator(MovieCode movieCode, int rentalDays) throws InvalidMovieInformationException {
        return switch (movieCode) {
            case REGULAR -> new RegularMovieRentalCalculator(rentalDays);
            case NEW -> new NewMovieRentalCalculator(rentalDays);
            case CHILDREN -> new ChildrensMovieRentalCalculator(rentalDays);
            default -> throw new InvalidMovieInformationException("Moviecode: " + movieCode + ": "
                    + movieCode.getDescription() + " is not supported");
        };
    }
}
