package design.patterns.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape decoratedShape = new RedShapeDecorator(circle);
        decoratedShape.draw();
    }
}
