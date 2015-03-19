package chapter11.dealing_with_generalization.template_method;

import java.util.Date;

public class PrefereredCustomer extends Customer {

    @Override
    protected double chargeFor(Date date) {
        return 100 * 0.75;
    }

}
