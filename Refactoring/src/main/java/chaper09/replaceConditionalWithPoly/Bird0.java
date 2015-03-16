package chaper09.replaceConditionalWithPoly;

public class Bird0 {

	public static int AFRICAN = 0;
	public static int EUROPEAN = 1;
	public static int ASIAN = 2;

	private float baseSpeed;

	private int type;

	public float getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(float baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public float getSpeed() {
		if (type == AFRICAN) {
			return baseSpeed + 100;
		}

		if (type == EUROPEAN) {
			return baseSpeed * 75;
		}

		if (type == ASIAN) {
			return baseSpeed + 50;
		}

		throw new IllegalStateException();
	}
}
