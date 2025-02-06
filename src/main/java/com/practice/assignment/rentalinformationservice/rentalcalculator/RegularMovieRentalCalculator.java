package com.practice.assignment.rentalinformationservice.rentalcalculator;

public class RegularMovieRentalCalculator implements MovieRentalCalculator {

    private static final double DAY_RENTAL = 1.5;
    private static final double DEFAULT_RENTAL_FOR_REGULAR_MOVIE_FOR_STANDARD_RENTAL_DAYS = 2.0;
    private static final int DEFAULT_FREQUENT_BONUS_POINTS = 1;
    private static final int STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE = 2;

    private final int rentalDays;

    RegularMovieRentalCalculator(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public double calculateRent() {
        double rentalAmount = DEFAULT_RENTAL_FOR_REGULAR_MOVIE_FOR_STANDARD_RENTAL_DAYS;
        if (rentalDays > STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE) {
            rentalAmount += (rentalDays - STANDARD_RENTAL_DAYS_FOR_REGULAR_MOVIE) * DAY_RENTAL;
        }
        return rentalAmount;
    }

    @Override
    public int calculateBonusPoints() {
        return DEFAULT_FREQUENT_BONUS_POINTS;
    }
}
