package concurrency.jcip.chapter02;

public class RaceCoditionCheckThenAct {
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			Thread t = new MyThread();
			
			t.start();
		}
	}
}

class LazyInitRace {
	public static LazyInitRace instance = null;

	private LazyInitRace() {

	}

	public static LazyInitRace getInstance() {
		if (instance == null) {
			instance = new LazyInitRace();
		}
		return instance;
	}
}

class MyThread extends Thread {

	@Override
	public synchronized void start() {
		System.out.println(LazyInitRace.getInstance());
	}

}
