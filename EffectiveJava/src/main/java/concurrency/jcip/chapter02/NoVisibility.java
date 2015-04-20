package concurrency.jcip.chapter02;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);

		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			new ReaderThread().start();
			number = 10;
			ready = true;
		}
	}
}
