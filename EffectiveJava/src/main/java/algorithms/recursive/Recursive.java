package algorithms.recursive;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public void test() {

    }

    static <E> void printArray(E[] a, int size) {
        if (a == null) {
            System.out.println(a);
            return;
        }

        if (size == 0) {
            return;
        }
        System.out.println(a[size - 1]);
        printArray(a, size - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        printArray(numbers, 5);
        List<?> list = new ArrayList<>();
        System.out.println(list);
    }
}
