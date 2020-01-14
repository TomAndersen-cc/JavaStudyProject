package DesignPattern.SimpleFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class SimpleFactoryPatternDemo {
    public static void main(String[] args) {
        // 创建一个工厂类
        SimpleShapeFactory simpleShapeFactory = new SimpleShapeFactory();
        // 通过工厂类创建各种对象，用户只需要知道对应的类名即可
        Shape shape1 = simpleShapeFactory.getShape("Rectangle");
        shape1.draw();

        Shape shape2 = simpleShapeFactory.getShape("Circle");
        shape2.draw();

        Shape shape3 = simpleShapeFactory.getShape("Square");
        shape3.draw();

    }
}
