package being_adaptive;

public class TukeyAdapter implements Duck {
	private Turkey turkey;

	public TukeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.globble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
