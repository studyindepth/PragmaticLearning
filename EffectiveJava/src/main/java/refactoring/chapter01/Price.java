package refactoring.chapter01;

public abstract class Price {

    abstract public PriceCode getPriceCode();

    abstract public double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
