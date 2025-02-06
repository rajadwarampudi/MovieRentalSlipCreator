package com.practice.assignment.rentalinformationservice.rentalcalculator;

public class ChildrensMovieRentalCalculator implements MovieRentalCalculator {

    private static final double DAY_RENTAL = 1.5;
    private static final double DEFAULT_RENTAL_FOR_CHILDREN_MOVIE__STANDARD_RENTAL_DAYS = 1.5;
    private static final int DEFAULT_FREQUENT_BONUS_POINTS = 1;
    private static final int STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE = 3;

    private final int rentalDays;

    ChildrensMovieRentalCalculator(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public double calculateRent() {
        double rentalAmount = DEFAULT_RENTAL_FOR_CHILDREN_MOVIE__STANDARD_RENTAL_DAYS;
        if (rentalDays > STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE) {
            rentalAmount += (rentalDays - STANDARD_RENTAL_MOVIE_FOR_CHILDREN_MOVIE) * DAY_RENTAL;
        }
        return rentalAmount;
    }

    @Override
    public int calculateBonusPoints() {
        return DEFAULT_FREQUENT_BONUS_POINTS;
    }
}
