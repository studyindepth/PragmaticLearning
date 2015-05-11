package java8;

public class Lambadas {
    public static void main(String[] args) {
        Operation plus = (a, b) -> a + b;
        plus.perform(1, 2);
    }

    static interface Operation {
        int perform(int a, int b);
    }
}
