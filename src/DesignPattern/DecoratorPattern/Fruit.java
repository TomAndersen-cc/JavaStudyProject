package DesignPattern.DecoratorPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
class Fruit extends Decorator {
    // 由于在子类中必须要初始化父类，因此当父类只有带参的构造函数时，
    // 子类中也必须要实现相同参数列表的构造函数
    public Fruit(Sweet sweet) {
        super(sweet);
    }

    public String getDescription() {
        return super.getDescription() + "This is a sweet fruit cake!";// ③
    }

}
