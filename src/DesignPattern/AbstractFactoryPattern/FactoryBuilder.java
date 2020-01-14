package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class FactoryBuilder {
    // 工厂的工厂，
    public static AbstractFactory getFactory(String factory) {
        if (factory == null) return null;
        if (factory.equalsIgnoreCase("Shape")) {
            System.out.println("A ShapeFactory was built.");
            return new ShapeFactory();
        }
        if (factory.equalsIgnoreCase("Color")) {
            System.out.println("A ColorFactory was built.");
            return new ColorFactory();
        }
        return null;
    }
}
