package tests;

public class Varargs {
    public static void main(String[] args) {
        Object o = null;
        print(o);
    }

    static void print(Object... o) {
        if (o != null) {
            System.out.println("OK");
        }
    }
}
