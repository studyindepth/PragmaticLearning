package tests;

public class Autoboxings {
    static void go(Integer x) {
        System.out.println("INTEGER");
    }

    static void go(long x) {
        System.out.println("long");
    }

    static void go(Long x) {
        System.out.println("LONG");
    }

    static void go(short x) {
        System.out.println("short");
    }

    public static void main(String[] args) {
        int i = 5;
        go(i);
    }
}
