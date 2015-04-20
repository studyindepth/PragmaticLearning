package tests;

public class Inheritances {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Programmer();
        p1.hello();
        p2.hello();
    }
}

class Person {
    public void hello() {
        System.out.println("Person");
    }
}

class Programmer extends Person {

    public void hello() {
        System.out.println("Programmer");
    }

}