package design.patterns.visitor;

public class Monitor implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor visitor) {
		visitor.accept(this);
	}

	@Override
	public String toString() {
		return "Monitor";
	}

}
