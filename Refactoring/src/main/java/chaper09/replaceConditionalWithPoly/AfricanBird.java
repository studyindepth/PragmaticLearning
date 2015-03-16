package chaper09.replaceConditionalWithPoly;

public class AfricanBird extends Bird1 {

	public AfricanBird(float baseSpeed) {
		super(baseSpeed);
	}

	@Override
	public float getSpeed() {
		return baseSpeed + 100;
	}

}
