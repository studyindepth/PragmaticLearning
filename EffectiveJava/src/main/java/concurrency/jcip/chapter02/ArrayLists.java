package concurrency.jcip.chapter02;

import java.util.List;

import com.google.common.collect.Lists;

public class ArrayLists {
	public static void main(String[] args) {
		for (int i = 0; i < 19; i++) {
			Thread t = new Add();
			t.start();
		}
	}
}

class Add extends Thread {

	@Override
	public void run() {
		List<String> list = Lists.newArrayList();
		list.add("a");
		list.add("b");
		
		System.out.println(list.get(0) == "a");
		System.out.println(list.get(1) == "b");
	}
	
}
