package tests;

public class RaceConditions {

	public static void main(String[] args) throws Exception {
		Thread thread1 = new Thread(new SingletonClient());
		Thread thread2 = new Thread(new SingletonClient());
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		System.out.println(Singleton.getInstance().getValue());
	}
}

class Singleton {
	private static Singleton instance;
	private int value;

	public synchronized void increment() {
		value++;
	}

	public synchronized int getValue() {
		return value;
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

class SingletonClient implements Runnable {

	@Override
	public void run() {
		Singleton.getInstance().increment();
	}
}
