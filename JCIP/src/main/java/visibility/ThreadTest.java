package visibility;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

	static volatile int count = 0;
	static Holder holder = new Holder();

	static synchronized void add(String s) {
		System.out.println("-----------------writing--------------" + Thread.currentThread());
		holder.add(s);
		count++;
		System.out.println("-----------------written--------------" + Thread.currentThread());
	}

	static void checkSize() {
		int size = holder.size();
		boolean b = count != size;
		if (b) {
			System.out.println("count " + count);
			System.out.println("size " + size);
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) throws Exception {
		Thread writer = new Writer();
		writer.start();
		writer.join();
		Thread writer1 = new Writer();
		writer1.start();
		writer1.join();
		Thread reader = new Reader();
		reader.start();
	}

	static class Writer extends Thread {
		@Override
		public void run() {
			add("s");
		}
	}

	static class Reader extends Thread {
		@Override
		public void run() {
			while (true) {
				checkSize();
			}
		}
	}

	static class Holder {
		List<String> list = new ArrayList<>();

		public void add(String s) {
			list.add(s);
		}

		public int size() {
			return list.size();
		}
	}
}
