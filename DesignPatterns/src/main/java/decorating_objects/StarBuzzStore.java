package decorating_objects;

public class StarBuzzStore {
	public static void main(String[] args) {
		Beverage b = new Espresso(50, "Coffe espresso");
		b.addCondiment(new Milk("Milk", 10));
		System.out.println(b.getDescription());
		System.out.println(b.cost());
	}
}
