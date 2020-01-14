package DesignPattern.SingletonPattern;

/**
 * @Author TomAndersen
 * @Date 2019/12/26
 * @Version
 * @Description
 */
public class SingletonPattern {
    // 静态内部类式单例模式
    private static class InstanceBuilder{
        static final SingletonPattern instance = new SingletonPattern();
    }
    private SingletonPattern(){};
    public static SingletonPattern getInstance(){
        return InstanceBuilder.instance;
    }
}
