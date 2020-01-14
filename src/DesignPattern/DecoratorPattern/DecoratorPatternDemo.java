package DesignPattern.DecoratorPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Decorator decorator = new Chocolate(new Fruit(new SweetCake()));
        System.out.println(decorator.getDescription());
    }
}

