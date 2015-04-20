package ooad;

public class Sub implements A, B {

    @Override
    public void m() {
        System.out.println("x");
    }

    public static void main(String[] args) {
        A a = new Sub();
        B b = new Sub();
        a.m();
        b.m();
    }
}
