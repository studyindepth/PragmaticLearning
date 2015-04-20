package reflection;

public class Mocking {

    public static <T> void mock(T t) {

    }

    public static String f() {
        return "abc";
    }

    public static void main(String[] args) {
        mock(f());
    }
}
