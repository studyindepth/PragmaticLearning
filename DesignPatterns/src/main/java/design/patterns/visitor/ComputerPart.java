package design.patterns.visitor;

public interface ComputerPart {
	void accept(ComputerPartVisitor visitor);
}
