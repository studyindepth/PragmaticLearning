package design.patterns.visitor;

import java.util.Arrays;
import java.util.List;

public class Computer implements ComputerPart {

	List<ComputerPart> parts;

	@Override
	public void accept(ComputerPartVisitor visitor) {
		for (ComputerPart computerPart : parts) {
			computerPart.accept(visitor);
		}
		visitor.accept(this);
	}

	public Computer(List<ComputerPart> parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return "Computer";
	}

	public static void main(String[] args) {
		Computer computer = new Computer(Arrays.asList(new Mouse(),
				new Monitor(), new Keyboard()));
		ComputerPartVisitor visitor = new DisplayVisitor();
		computer.accept(visitor);

	}
}
