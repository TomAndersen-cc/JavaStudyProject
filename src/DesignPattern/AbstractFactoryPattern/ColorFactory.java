package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class ColorFactory extends AbstractFactory{
    // Color可以看做是某个产品，而不同的Color则代表不同品牌的产品
    public Color getColor(String color) {
        if (color == null) return null;
        if (color.equalsIgnoreCase("Green")) {
            return new Green();
        }
        if (color.equalsIgnoreCase("Red")) {
            return new Red();
        }
        if (color.equalsIgnoreCase("Blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
