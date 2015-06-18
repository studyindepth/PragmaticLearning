package composing_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());

	public boolean putIfAbsent(E e) {
		synchronized (list) {
			boolean absent = !list.contains(e);
			if (absent) {
				list.add(e);
			}
			return absent;
		}
	}

	// wrong lock
	public synchronized boolean putIfAbsent1(E e) {
		boolean absent = !list.contains(e);
		if (absent) {
			list.add(e);
		}
		return absent;
	}
}
