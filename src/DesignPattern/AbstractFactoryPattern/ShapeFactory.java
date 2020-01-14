package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    // 可以将Shape看做是某个产品，而不同的shape则代表不同品牌的产品
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        return null;
    }
}
