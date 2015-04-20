package refactoring.chapter01;

import java.util.List;

import com.gs.collections.impl.list.mutable.FastList;

public class Customer {

    private String name;
    private List<Rental> rentals = new FastList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String result = "Rental record for " + getName() + " \n";
        result += getRentalDetails();
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points ";
        return result;
    }

    private String getRentalDetails() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append(rental.getRentalSummary());
        }
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
