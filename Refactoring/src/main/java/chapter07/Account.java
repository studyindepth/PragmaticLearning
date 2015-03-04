package chapter07;

public class Account {

    // account can change its type
    private AccountType accountType;
    private int daysOverDrawn;

    public Account(AccountType accountType, int daysOverDrawn) {
        this.accountType = accountType;
        this.daysOverDrawn = daysOverDrawn;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getDaysOverDrawn() {
        return daysOverDrawn;
    }

    public double bankCharge() {
        if (daysOverDrawn == 0) {
            return 1;
        } else {
            return accountType.getOverDraftCharge(daysOverDrawn);
        }
    }

    public double interestForAmountOfDays(double amount, int days) {
        return accountType.interestForAmountOfDays(amount, days);
    }

    public double interestForAmountOfDays1(double amount, int days) {
        return accountType.getInterestRate() * amount * days / 365;
    }

    public double interestForAmountOfDays2(double amount, int days) {
        return getInterestRate() * amount * days / 365;
    }

    private double getInterestRate() {
        return accountType.getInterestRate();
    }

}
