package tests;

import java.util.Arrays;

class ArrayTest {
    public static void main(String[] args) {
        String[] a = { "a", "b", "c" };
        String[] A = { "a", "b", "c" };
        if (A == a) {
            System.out.println(true);
        } else {
            A = a;
            System.out.println(false);
        }
        for (int i = 0; i < 3; i++) {
            A[i] = A[i].toUpperCase();
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(a));
    }
}

interface HeavenlyBody {
    String describe();
}

class Star {
    String starName;

    public String describe() {
        return "star " + starName;
    }
}

class Planet extends Star {
    String name;

    public String describe() {
        return "planet " + name + " orbiting star " + starName;
    }
}
