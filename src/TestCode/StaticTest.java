package TestCode;

/**
 * @Author
 * @Version
 * @Date 2019/10/8
 */
public class StaticTest {
    public static int TEST_VALUE = 10;

    static {
        int TEST_VALUE_2 = 101;
    }

    public static void main(String[] args) {
        System.out.println(StaticTest.TEST_VALUE);
        //这说明在static代码块中声明的变量并不是静态变量，只是代表这个代码块会在类被加载时候运行
        //static代码块一般用于类的配置的初始化，如加载配置文件等等
        //System.out.println(StaticTest.TEST_VALUE_2);

    }

}


