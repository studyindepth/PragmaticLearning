package visibility;

import java.util.ArrayList;
import java.util.List;

public class VisibilityTest {

	static EntryHolder holder = new EntryHolder();

	static synchronized void add(Entry e) {
		holder.add(e);
	}

	public static void main(String[] args) {
		synchronized (holder) {
			for (int i = 0; i < 5; i++) {
				holder.add(new Entry());
			}
		}
		new Reader().start();
	}
}

// effective immutable
class EntryHolder {

	private List<Entry> entries = new ArrayList<>();

	public void add(Entry e) {
		entries.add(e);
	}

	public int size() {
		return entries.size();
	}
}

class Entry {

}

class Writer extends Thread {

	@Override
	public void run() {
	}

}

class Reader extends Thread {
	@Override
	public void run() {
		int size = VisibilityTest.holder.size();
		System.out.println(size);
		if (size % 5 != 0) {
			// System.exit(1);
			throw new RuntimeException();
		}
	}
}