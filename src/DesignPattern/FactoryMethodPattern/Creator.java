package DesignPattern.FactoryMethodPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public abstract class Creator {
    protected Shape create(String shape) {
        System.out.println("Preparing to create......");
        return getShape(shape);
    }

    protected abstract Shape getShape(String shape);
}
