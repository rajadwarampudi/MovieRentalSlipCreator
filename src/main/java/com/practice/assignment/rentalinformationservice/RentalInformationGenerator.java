package com.practice.assignment.rentalinformationservice;

import com.practice.assignment.rentalinformationservice.exceptions.InvalidMovieInformationException;

import java.util.Map;

public class RentalInformationGenerator {

    private static final Map<String, Movie> movies = populateMovieInformationMap();
    private static final int DAY_RENTAL_FOR_NEW_TYPE_MOVIE = 3;
    private static final int DEFAULT_FREQUENT_BONUS_POINTS = 1;
    private static final double DEFAULT_RENTAL_FOR_REGULAR_MOVIE_FOR_STANDARD_RENTAL_DAYS = 2.0;
    private static final double DEFAULT_RENTAL_FOR_CHILDREN_MOVIE__STANDARD_RENTAL_DAYS = 1.5;
    private static final int STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE = 2;
    private static final int STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE = 3;
    private static final double DAY_RENTAL = 1.5;

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
        for (MovieRentalInformation rentalInformation : customer.rentals()) {
            Movie currentMovie = getCurrentMovie(rentalInformation.movieId());
            MovieCode movieCode = currentMovie.code();
            double rentalAmountForCurrentMovie = calculateAmount(movieCode, rentalInformation.days());

            statement.append("\t").append(currentMovie.title()).append("\t")
                    .append(rentalAmountForCurrentMovie).append("\n");

            totalRentalAmount += rentalAmountForCurrentMovie;
            frequentBonusPoints += getFrequentBonusPoints(movieCode, rentalInformation.days());
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
            throw new InvalidMovieInformationException("Invalid movie id: " + movieId);
        }
    }

    private int getFrequentBonusPoints(MovieCode movieCode, int rentalDays) {
        int frequentBonusPoints = DEFAULT_FREQUENT_BONUS_POINTS;
        return (MovieCode.NEW == movieCode && rentalDays > 2) ? frequentBonusPoints + 1 : frequentBonusPoints;
    }


    private double calculateAmount(MovieCode movieCode, int rentalDays) throws InvalidMovieInformationException {
        return switch (movieCode) {
            case REGULAR -> getRentalForRegularMovie(rentalDays);
            case NEW -> rentalDays * DAY_RENTAL_FOR_NEW_TYPE_MOVIE;
            case CHILDREN -> getRentalForChildrenMovie(rentalDays);
            default -> throw new InvalidMovieInformationException("Moviecode: " + movieCode + ": "
                    + movieCode.getDescription() + "is not supported");
        };
    }

    private double getRentalForRegularMovie(int rentalDays) {
        double rentalAmount = DEFAULT_RENTAL_FOR_REGULAR_MOVIE_FOR_STANDARD_RENTAL_DAYS;
        if (rentalDays > STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE) {
            rentalAmount += (rentalDays - STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE) * DAY_RENTAL;
        }
        return rentalAmount;
    }

    private double getRentalForChildrenMovie(int rentalDays) {
        double rentalAmount = DEFAULT_RENTAL_FOR_CHILDREN_MOVIE__STANDARD_RENTAL_DAYS;
        if (rentalDays > STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE) {
            rentalAmount += (rentalDays - STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE) * DAY_RENTAL;
        }
        return rentalAmount;
    }
}
