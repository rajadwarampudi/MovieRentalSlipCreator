package com.practice.assignment.rentalinformationservice.rentalcalculator;

public class NewMovieRentalCalculator implements MovieRentalCalculator {

    private static final int DEFAULT_FREQUENT_BONUS_POINTS = 1;
    private static final int DAY_RENTAL_FOR_NEW_TYPE_MOVIE = 3;

    private final int rentalDays;

    NewMovieRentalCalculator(int rentalDays) {
        this.rentalDays = rentalDays;
    }


    @Override
    public double calculateRent() {
        return rentalDays * DAY_RENTAL_FOR_NEW_TYPE_MOVIE;
    }

    @Override
    public int calculateBonusPoints() {
        return (rentalDays > 2) ? DEFAULT_FREQUENT_BONUS_POINTS + 1 : DEFAULT_FREQUENT_BONUS_POINTS;
    }
}
