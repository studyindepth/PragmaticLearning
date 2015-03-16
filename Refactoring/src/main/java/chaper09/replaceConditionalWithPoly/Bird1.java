package chaper09.replaceConditionalWithPoly;

public abstract class Bird1 {
	protected float baseSpeed;

	public Bird1(float baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public float getBaseSpeed() {
		return baseSpeed;
	}

	public abstract float getSpeed();
}
