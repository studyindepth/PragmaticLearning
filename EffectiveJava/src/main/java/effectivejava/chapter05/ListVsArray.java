package effectivejava.chapter05;

import java.util.ArrayList;
import java.util.List;

public class ListVsArray {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Object[] objects = new Long[1];
		// objects[0] = "abc";
		List<?>[] l = new ArrayList<?>[100];
		@SuppressWarnings("unused")
		List<?> list = new ArrayList<>();
		System.out.println(l);

	}
}
