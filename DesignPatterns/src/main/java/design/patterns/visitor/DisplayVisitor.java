package design.patterns.visitor;

public class DisplayVisitor implements ComputerPartVisitor {

	@Override
	public void accept(Monitor part) {
		print(part);
	}

	private void print(ComputerPart part) {
		System.out.println(part);
	}

	@Override
	public void accept(Mouse part) {
		print(part);
	}

	@Override
	public void accept(Keyboard part) {
		print(part);
	}

	@Override
	public void accept(Computer part) {
		print(part);
	}

}
