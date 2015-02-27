package design.patterns.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape decoratedShape = new RedBorderShapeDecorator(circle);
        decoratedShape.draw();
        Shape paintedShape = new ColorPaintingShapeDecorator(decoratedShape);
        paintedShape.draw();
    }
}
