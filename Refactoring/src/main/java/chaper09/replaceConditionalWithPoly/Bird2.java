package chaper09.replaceConditionalWithPoly;

public class Bird2 {
	private BirdType type;
	private int baseSpeed;

	public float getSpeed() {
		return type.getSpeed();
	}

}
