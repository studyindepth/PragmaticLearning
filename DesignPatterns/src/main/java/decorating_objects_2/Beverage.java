package decorating_objects_2;

public abstract class Beverage {

	private double cost;

	private String description;

	public Beverage(double cost, String descrition) {
		this.cost = cost;
		this.description = descrition;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrition) {
		this.description = descrition;
	}

	
}
