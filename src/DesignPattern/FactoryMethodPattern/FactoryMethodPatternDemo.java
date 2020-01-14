package DesignPattern.FactoryMethodPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        Creator creatorA = new ShapeCreatorA();
        Shape shape1 = creatorA.create("Rectangle");
        shape1.draw();

        Creator creatorB = new ShapeCreatorB();
        Shape shape2 = creatorB.create("Circle");
        shape2.draw();

    }
}
