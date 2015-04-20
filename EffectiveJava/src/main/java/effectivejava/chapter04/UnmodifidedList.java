package effectivejava.chapter04;

import java.util.AbstractList;
import java.util.List;

public class UnmodifidedList<E> extends AbstractList<E> {

	private Object[] elements;

	private UnmodifidedList(int size) {
		elements = new Object[size];
	}

	public static <E> List<E> of() {
		return new UnmodifidedList<E>(0);
	}

	@SafeVarargs
	public static <E> List<E> of(E... elements) {
		int size = elements.length;
		UnmodifidedList<E> list = new UnmodifidedList<>(size);
		for (int i = 0; i < elements.length; i++) {
			list.elements[i] = elements[i];
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkRange(index);
		return (E) elements[index];

	}

	private void checkRange(int index) {
		if (index < 0 || index > this.elements.length) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return elements.length;
	}

	public static void main(String[] args) {
		List<Integer> constants = UnmodifidedList.of(1, 2, 3, 4);
		for (Object constant : constants) {
			System.out.println(constant);
		}
		//System.out.println(constants.get(6));
	}
}
