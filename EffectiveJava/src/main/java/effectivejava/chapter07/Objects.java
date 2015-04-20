package effectivejava.chapter07;

public class Objects {

    private Objects() {

    }

    public static <T> void checkNotNull(T t, T... args) {
        System.out.println(args + "s");
    }

    public static <T> void checkNotNull(T t) {
        System.out.println(t);
    }

    public static <T> void checkNotNull(T t, T t1) {
        System.out.println(t);
    }

    // public static void readLong(long l) {
    // System.out.println("long");
    // }

    public static void readLong(Long l) {
        System.out.println("Long");
    }

    public static void main(String[] args) {
        Object c = null;
        checkNotNull(c, c);
        readLong(1l);

        int[] x = new int[0];
       // System.out.println(x[0]);
        for (int i : x) {
            System.out.println(i);

        }
    }
}
