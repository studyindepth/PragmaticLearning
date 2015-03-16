package hfooad.chapter01;

public abstract class Duck {
    public void swim() {
        System.out.println("Swimming...");
    }

    public void quack() {
        System.out.println("Quacking...");
    }

    // fly changes
    public abstract void fly();

    public abstract void display();
}
