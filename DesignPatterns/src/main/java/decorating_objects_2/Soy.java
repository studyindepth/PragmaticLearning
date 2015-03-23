package decorating_objects_2;

public class Soy extends BeverageDecorator {

	public Soy(Beverage decoratedBeverage, double cost, String des) {
		super(decoratedBeverage, cost, des);
	}

	public String getDescription() {
		return getDecoratedBeverage().getDescription() + getdDes();
	}

	@Override
	public double getCost() {
		return getDecoratedBeverage().getCost() + getdCost();
	}

}
