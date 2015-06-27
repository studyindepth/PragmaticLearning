package tests;

public class ThreadTest {
    public static void main(String[] args) {
        new SingletonClient().start();
        new SingletonClient().start();
    }
}

class Singleton {
    private static Singleton instance;

    public void doSomething() {
        // do something
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonClient extends Thread {

    @Override
    public void run() {
        Singleton.getInstance().doSomething();
    }
}