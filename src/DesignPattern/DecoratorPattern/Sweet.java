package DesignPattern.DecoratorPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/11
 * @Version
 * @Description 本Demo是装饰者模式（Decorator Mode）的一个小示例
 */

public interface Sweet {
    // 接口中定义的变量都是强制为public final static 的，不论是否使用修饰符显式修饰都一样
    public static final int s = 1;

    // 接口中定义的方法都强制为public abstract修饰的，不论是否使用修饰符显式修饰都一样
    public abstract String getDescription();

}
