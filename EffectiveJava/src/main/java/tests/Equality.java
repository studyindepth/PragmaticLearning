package tests;

public class Equality {
	public static void main(String[] args) {
		Integer a = 0;
		Integer b = assign(a);
		System.out.println(b);
		System.out.println(a == b);
		System.out.println(a.equals(b));
	}

	static Integer assign(Integer a) {
		return a++;
	}
}
