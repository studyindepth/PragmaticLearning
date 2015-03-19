package chapter11.dealing_with_generalization.template_method;

import java.util.Date;

public abstract class Customer {

    private void addBill(Date date, double charge) {
        System.out.println("create");
    }
    
    public void createBill(Date date) {
        double charge = chargeFor(date);
        addBill(date, charge);
    }

    protected abstract double chargeFor(Date date); 

}
