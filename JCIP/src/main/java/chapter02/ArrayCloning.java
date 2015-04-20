package chapter02;

public class ArrayCloning {
	public static void main(String[] args) {
		String[] a = { "1", "2", "3" };
		String[] b = a.clone();
		
		a[0] = "d";
		System.out.println(b[0]);
	}
}
