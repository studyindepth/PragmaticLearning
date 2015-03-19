package chapter11.dealing_with_generalization.template_method;

import java.util.Date;

public class RegularCustomer extends Customer {
    protected double chargeFor(Date date) {
        return 100;
    }
}
