package DesignPattern.FactoryMethodPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class ShapeCreatorA extends Creator {

    @Override
    protected Shape getShape(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleA();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new SquareA();
        } else if (shape.equalsIgnoreCase("CIRCLE")) {
            return new CircleA();
        }
        return null;
    }
}
