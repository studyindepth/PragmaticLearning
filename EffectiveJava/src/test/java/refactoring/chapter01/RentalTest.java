package refactoring.chapter01;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RentalTest {

    private Rental rental;
    private double expectedAmount;

    public RentalTest(Rental rental, double expectedAmount) {
        this.rental = rental;
        this.expectedAmount = expectedAmount;
    }

    @Parameters(name = "{index}: {0}.getCharge() = {1}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] { { new Rental(new Movie("The hobbit", PriceCode.REGULAR), 1), 2 },
                { new Rental(new Movie("The hobbit 1", PriceCode.REGULAR), 3), 3.5 },
                { new Rental(new Movie("The hobbit 2", PriceCode.NEW_RELEASE), 1), 3 },
                { new Rental(new Movie("The hobbit 2", PriceCode.CHILDRENS), 1), 1.5 },
                { new Rental(new Movie("The hobbit 2", PriceCode.CHILDRENS), 4), 3 } });
    }

    @Test
    public void testGetCharge() {
        assertEquals(rental.getCharge(), expectedAmount, 0.0);
    }
}
