package any;

public class Returns {
    static int get() {
        int i = 100;
        return i = 1;
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
