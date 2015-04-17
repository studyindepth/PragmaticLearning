package being_adaptive;

/**
 * client
 *
 */
public class DuckTest {
	public static void main(String[] args) {
		Duck duck = new WildDuck();
		duck.quack();
		Turkey turkey = new WildTurkey();
		turkey.globble();

		Duck duckAdappter = new TukeyAdapter(turkey);
		duckAdappter.quack();
	}
}
