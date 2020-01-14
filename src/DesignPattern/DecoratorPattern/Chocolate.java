package DesignPattern.DecoratorPattern;


/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
class Chocolate extends Decorator {

    public Chocolate(Sweet sweet) {
        super(sweet);
    }

    public String getDescription() {
        return super.getDescription() + "This is a sweet chocolate cake!";// ①
    }
}
