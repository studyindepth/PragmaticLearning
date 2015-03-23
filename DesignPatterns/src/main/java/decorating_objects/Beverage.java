package decorating_objects;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Beverage {
	private double baseCost;

	private String description;

	private Collection<Condiment> condiments;

	public double cost() {
		return baseCost + getExtraCost();
	}

	private double getExtraCost() {
		double result = 0.0;
		for (Condiment condiment : condiments) {
			result += condiment.getCost();
		}
		return result;
	}

	public boolean addCondiment(Condiment e) {
		return condiments.add(e);
	}

	public Beverage(double baseCost, String des) {
		this.baseCost = baseCost;
		this.description = des;
		condiments = new ArrayList<>();
	}

	public String getDescription() {
		return description + getExtraDescription();
	}

	private String getExtraDescription() {
		String result = "";
		for (Condiment condiment : condiments) {
			result += " with " + condiment.getDescription();
		}
		return result;
	}
}
