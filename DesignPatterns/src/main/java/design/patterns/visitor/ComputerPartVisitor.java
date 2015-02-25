package design.patterns.visitor;

public interface ComputerPartVisitor {
	void accept(Monitor part);
	void accept(Mouse part);
	void accept(Keyboard part);
	void accept(Computer part);
}
