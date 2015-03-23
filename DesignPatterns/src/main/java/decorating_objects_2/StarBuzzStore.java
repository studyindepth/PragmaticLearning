package decorating_objects_2;

public class StarBuzzStore {
	public static void main(String[] args) {
		Beverage b = new Espresso(10, "Espresso");
		BeverageDecorator soy = new Soy(b, 2, "Soy");
		System.out.println(soy.getCost());
		System.out.println(soy.getDescription());
	}
}
