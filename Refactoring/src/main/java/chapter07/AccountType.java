package chapter07;

public class AccountType {
    private boolean preminum;
    private double interestRate;

    public boolean isPreminum() {
        return preminum;
    }

    public AccountType(boolean preminum) {
        this.preminum = preminum;
    }

    public void setPreminum(boolean preminum) {
        this.preminum = preminum;
    }

    public double getOverDraftCharge(int daysOverDrawn) {
        if (isPreminum()) {
            return daysOverDrawn * 5;
        } else {
            return daysOverDrawn * 6;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double interestForAmountOfDays(double amount, int days) {
        return interestRate * amount * days / 365;
    }

}
