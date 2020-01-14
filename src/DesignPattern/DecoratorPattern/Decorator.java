package DesignPattern.DecoratorPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
abstract class Decorator implements Sweet {
    Sweet sweet;

    public Decorator(Sweet sweet) {
        this.sweet = sweet;
    }

    public String getDescription() {
        return sweet.getDescription();// ② ④ ⑥
    }
}
