package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // 获取Shape工厂
        AbstractFactory colorFactory = FactoryBuilder.getFactory("color");
        Color color1 = colorFactory.getColor("red");
        color1.fill();
        Color color2 = colorFactory.getColor("blue");
        color2.fill();
        Color color3 = colorFactory.getColor("green");
        color3.fill();
        // 获取Color工厂
        AbstractFactory shapeFactory = FactoryBuilder.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("square");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();
    }
}
