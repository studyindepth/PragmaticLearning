package tests;

import java.lang.reflect.Field;

public class Ints {
    public static void main(String[] args) throws Exception {
        Integer a = 1;
        Integer b = 2;
        Integer c = 1;
        Field f = Integer.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set(a, 2);
        System.out.println(a + b + c);

        int i = 012;
        System.out.println(i);

        if (i == 10.0) {
            System.out.println(true);
        }
    }
}
