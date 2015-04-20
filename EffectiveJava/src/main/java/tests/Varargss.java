package tests;

public class Varargss {

    static void go(long x, long y) {
        System.out.println("long");
    }

    static void go(byte... x) {
        System.out.println("byte");
    }

    static void go(Byte... x) {
        System.out.println("BYTE");
    }

    public static void main(String[] args) {
        byte b = 5;
        go(b, b);
    }
}
