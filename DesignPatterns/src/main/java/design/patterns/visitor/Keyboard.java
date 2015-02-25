package design.patterns.visitor;

public class Keyboard implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor visitor) {
		visitor.accept(this);
	}
	@Override
	public String toString() {
		return "KeyBoard";
	}
}
