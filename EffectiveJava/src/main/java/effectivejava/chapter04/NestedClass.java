package effectivejava.chapter04;

public class NestedClass {

	public void foo() {
		NestedClass.this.foo();
	}
	@SuppressWarnings("unused")
	private class NonStatic {
		void foo() {
			NestedClass.this.foo();
		}
	}
	
	public interface I {
		void i();
	}
	
	static class C {
		
	}
	
	
}
