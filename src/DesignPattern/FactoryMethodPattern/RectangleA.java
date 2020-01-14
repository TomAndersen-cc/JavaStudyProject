package DesignPattern.FactoryMethodPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class RectangleA implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RectangleA::draw() method.");
    }
}
