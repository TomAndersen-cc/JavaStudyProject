package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
