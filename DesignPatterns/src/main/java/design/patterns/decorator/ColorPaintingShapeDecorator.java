package design.patterns.decorator;

public class ColorPaintingShapeDecorator extends ShapeDecorator {

    public ColorPaintingShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        paint(decoratedShape);
    }

    private void paint(Shape shape) {
        System.out.println("painted " + shape);
    }

}
