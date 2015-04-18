package sharing_objects;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        Object o = new Object();

        Object[] a = { o };
        Object[] b = Arrays.copyOf(a, 1);

        System.out.println(a[0]);
        System.out.println(b[0]);

        BigInteger in = new BigInteger("123");
        BigInteger i = in.setBit(100);
        System.out.println(in);
        System.out.println(i);
    }
}
