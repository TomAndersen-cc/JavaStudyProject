package DesignPattern.AbstractFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
