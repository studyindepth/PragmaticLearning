package design.patterns.visitor;

public class Mouse implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor visitor) {
		visitor.accept(this);
	}

	@Override
	public String toString() {
		return "Mouse";
	}
}
