package tests;

public class Test13 {

    public static void main(String[] args) {
        Derived b = new DeriDerived();
    }
}

class Base {
    public Base() {
        System.out.println("Base");
    }
}

class Derived extends Base {
    public Derived() {
        System.out.println("Derived");
    }
}

class DeriDerived extends Derived {
    public DeriDerived() {
        System.out.println("DeriDerived");
    }
}

class Point {
    private int x = 0, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Point() {
        this(0, 0);
    }
}
