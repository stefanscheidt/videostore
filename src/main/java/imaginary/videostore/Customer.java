package imaginary.videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental aRental) {
        rentals.add(aRental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder(String.format("Rental Record for %s\n", getName()));

        for (Rental each : rentals) {
            double thisAmount = 0;

            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR -> {
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                }
                case Movie.NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;
                case Movie.CHILDRENS -> {
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                }
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two-day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // show figures for this rental
            result.append(String.format("\t%s\t%s\n", each.getMovie().getTitle(), thisAmount));

            totalAmount += thisAmount;
        }

        // add footer lines
        result.append(String.format("Amount owed is %s\n", totalAmount));
        result.append(String.format("You earned %s frequent renter points", frequentRenterPoints));

        return result.toString();
    }

}
