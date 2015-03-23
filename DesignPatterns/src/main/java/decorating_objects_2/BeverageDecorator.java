package decorating_objects_2;

public abstract class BeverageDecorator extends Beverage {
	private Beverage decoratedBeverage;
	private double dCost;

	private String dDes;

	public BeverageDecorator(Beverage decoratedBeverage, double cost, String des) {
		super(0, null);
		dCost = cost;
		dDes = des;
		this.decoratedBeverage = decoratedBeverage;
	}

	public Beverage getDecoratedBeverage() {
		return decoratedBeverage;
	}

	public double getdCost() {
		return dCost;
	}

	public void setdCost(double dCost) {
		this.dCost = dCost;
	}

	public String getdDes() {
		return dDes;
	}

	public void setdDes(String dDes) {
		this.dDes = dDes;
	}

	public void setDecoratedBeverage(Beverage decoratedBeverage) {
		this.decoratedBeverage = decoratedBeverage;
	}

}
