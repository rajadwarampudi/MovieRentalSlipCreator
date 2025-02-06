package com.practice.assignment.rentalinformationservice;

import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;
import com.practice.assignment.rentalinformationservice.model.Customer;
import com.practice.assignment.rentalinformationservice.model.Movie;
import com.practice.assignment.rentalinformationservice.model.MovieRentalInformation;
import com.practice.assignment.rentalinformationservice.rentalcalculator.MovieRentalCalculator;
import com.practice.assignment.rentalinformationservice.rentalcalculator.MovieRentalCalculatorFactory;

import java.util.Map;
import java.util.logging.Logger;

public class RentalInformationGenerator {

    private static final Logger LOGGER = Logger.getLogger(RentalInformationGenerator.class.getName());

    private static final Map<String, Movie> movies = populateMovieInformationMap();

    /**
     * This method generates the rental statement for the given customer
     * and each movie that he/she rented and the grand total report at the end.
     * The rental amount for each movie is calculated based on the movie code and the number of rental days
     * The frequent bonus points by default 1 for each movie, and an additional point for a NEW type movie with
     * the rental days more than 2.
     *
     * @param customer The customer object that holds the customer's info and her/his rental information
     * @return generated statement in String format
     */
    public String generateStatement(Customer customer) throws InvalidMovieInformationException {
        double totalRentalAmount = 0;
        int frequentBonusPoints = 0;
        StringBuilder statement = new StringBuilder();
        statement.append("Rental Record for ").append(customer.name()).append("\n");
        MovieRentalCalculatorFactory movieRentalCalculatorFactory = new MovieRentalCalculatorFactory();
        for (MovieRentalInformation rentalInformation : customer.rentals()) {
            Movie currentMovie = getCurrentMovie(rentalInformation.movieId());
            MovieCode movieCode = currentMovie.code();
            MovieRentalCalculator movieRentalCalculator = movieRentalCalculatorFactory.getMovieRentalCalculator(
                    movieCode, rentalInformation.days());

            double rentalAmountForCurrentMovie = movieRentalCalculator.calculateRent();

            statement.append("\t").append(currentMovie.title()).append("\t")
                    .append(rentalAmountForCurrentMovie).append("\n");

            totalRentalAmount += rentalAmountForCurrentMovie;
            frequentBonusPoints += movieRentalCalculator.calculateBonusPoints();
        }
        statement.append("Amount owed is ").append(totalRentalAmount).append("\n");
        statement.append("You earned ").append(frequentBonusPoints).append(" frequent points\n");

        return statement.toString();
    }

    private static Map<String, Movie> populateMovieInformationMap() {
        return Map.of(
                "F001", new Movie("You've Got Mail", MovieCode.REGULAR),
                "F002", new Movie("Matrix", MovieCode.REGULAR),
                "F003", new Movie("Cars", MovieCode.CHILDREN),
                "F004", new Movie("Fast & Furious X", MovieCode.NEW));
    }

    private static Movie getCurrentMovie(String movieId) throws InvalidMovieInformationException {
        if (movies.containsKey(movieId)) {
            return movies.get(movieId);
        } else {
            LOGGER.severe("Invalid movie id: " + movieId);
            throw new InvalidMovieInformationException("Invalid movie id: " + movieId);
        }
    }
}
