package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
