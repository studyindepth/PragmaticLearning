package chapter02;

import java.math.BigInteger;

import net.jcip.annotations.Immutable;

@Immutable
public class CacheValue {

    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;

    public CacheValue(BigInteger lastNumber, BigInteger[] lastFactors) {
        if (lastNumber == null || lastFactors == null) {
            throw new IllegalArgumentException();
        }
        this.lastNumber = lastNumber;
        // Arrays.copyOf() also works
        this.lastFactors = lastFactors.clone();
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber.equals(i)) {
            return lastFactors.clone();
        } else {
            return null;
        }
    }

}
