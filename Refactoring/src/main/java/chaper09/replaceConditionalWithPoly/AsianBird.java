package chaper09.replaceConditionalWithPoly;

public class AsianBird extends Bird1 {

	public AsianBird(float baseSpeed) {
		super(baseSpeed);
	}

	@Override
	public float getSpeed() {
		return baseSpeed + 50;
	}

}
