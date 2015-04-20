package tests;

public class Inheritance {
    public static void main(String[] args) {
        A b = new B();
        System.out.println(b);
    }
}

class A {
    int a;

    public A(int a) {
        this.a = a;
    }

}

class B extends A {
    public B() {
        super(0);
    }

    int b;

}
