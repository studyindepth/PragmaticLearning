package refactoring.chapter01;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return getMovie().getCharge(daysRented);
    }

    @Override
    public String toString() {
        return "{Rental:{movie:\"" + movie.getTitle() + "\", daysRented:" + getDaysRented() + "}}";
    }

    public int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }

    public String getRentalSummary() {
        return "\t" + getMovie().getTitle() + "\t" + String.valueOf(getCharge()) + "\n";
    }

}
