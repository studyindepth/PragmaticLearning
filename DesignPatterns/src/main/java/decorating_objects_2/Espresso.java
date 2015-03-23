package decorating_objects_2;

public class Espresso extends Beverage {

	public Espresso(double cost, String des) {
		super(cost, des);
	}

	@Override
	public String getDescription() {
		return "espresso";
	}

}
