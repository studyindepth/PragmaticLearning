package decorating_objects;

public class Condiment {
	private String description;
	private double cost;

	public Condiment(String description, double cost) {
		this.description = description;
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}

}
