package effectivejava.chapter08;

public class Exceptions {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                try {
                    throw new IllegalArgumentException();
                } catch (Exception e) {
                }
            }
        }

        System.out.println("dfdf");
    }
}
