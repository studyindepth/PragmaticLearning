package composing_objects;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {
	private final Set<Integer> set = new HashSet<>();

	public boolean add(Integer e) {
		return set.add(e);
	}

	public void addTenThings() {
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			add(random.nextInt());
		}

		// Hidden iterator, may throw ConcurrentyModificationException
		System.out.println("added ten elements to " + set);
	}
}
