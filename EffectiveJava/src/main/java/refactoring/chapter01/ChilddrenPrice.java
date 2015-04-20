package refactoring.chapter01;

public class ChilddrenPrice extends Price {

    @Override
    public PriceCode getPriceCode() {
        return PriceCode.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

}
