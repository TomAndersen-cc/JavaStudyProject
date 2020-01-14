package DesignPattern.FactoryMethodPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class ShapeCreatorB extends Creator {
    @Override
    protected Shape getShape(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleB();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new SquareB();
        } else if (shape.equalsIgnoreCase("CIRCLE")) {
            return new CircleB();
        }
        return null;
    }
}
