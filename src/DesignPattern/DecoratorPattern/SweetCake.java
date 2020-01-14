package DesignPattern.DecoratorPattern;


;

class SweetCake implements Sweet {

    public String getDescription() {
        return "This is a sweet cake!"; // ⑤
    }
}

// 接口继承接口测试,结果：接口只能继承接口不能继承抽象类
/*interface Test1 extends Sweet{

}*/

// 抽象类可以继承接口，也可以继承抽象类
/*abstract class Test2 extends Decorator{
    public Test2(Sweet sweet) {
        super(sweet);
    }
}*/


