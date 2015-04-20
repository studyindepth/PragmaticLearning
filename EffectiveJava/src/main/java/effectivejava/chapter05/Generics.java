package effectivejava.chapter05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generics {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		add(strings, "abc");
		
		for (String string : strings) {
			System.out.println(string);
			
		}
		
		Set<?> set = new HashSet<String>();
		set.add(null);
		System.out.println(set instanceof Set<?>);
		
		for (Object object : set) {
			System.out.println(object);
		}
		
		System.out.println(set.getClass());
		System.out.println(int.class);
	}
	
	static <E> void add(List<E> list, E e) {
		list.add(e);
	}
}
