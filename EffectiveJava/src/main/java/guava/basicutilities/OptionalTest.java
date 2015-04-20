package guava.basicutilities;

import com.google.common.base.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer i = 100;
        Optional<Integer> op = Optional.of(i);
        System.out.println(op);
        Optional<Integer> in = Optional.absent();
        System.out.println(in.isPresent());
        System.out.println(in.get());
        // System.out.println(Optional.absent());

        Object j = null;
        String s = (String) j;
        System.out.println(s);

    }

}
