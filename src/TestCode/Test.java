package TestCode;


import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author TomAndersen
 * @Date 2019/12/26
 * @Version
 * @Description
 */
abstract class People {
    private int x = 0;
}

interface Person {
    int x = 1;
}

class Father {
    int age = 0;

    static {
        System.out.println("This is Father's static block!");
    }

    Father() {
        System.out.println("This is Father's constructor!");
    }

    void test() {
        System.out.println(age);
    }

    {
        System.out.println("This is Father's no-static block");
    }
}

class Child extends Father {
    private int myAge;
    private char c;
//    private String name;

    void test() {// 覆盖父类方法遵循2同2小1大原则
        System.out.println(myAge);
        System.out.println(c);
//        System.out.println(name);
    }
    void myFunction() throws Exception{
        System.out.println("This function will throw a Exception!");
        throw new Exception("A test Exception");
    }

    static {
        System.out.println("This is Child's static block!");
    }

    Child() {
        System.out.println("This is Child's constructor!");
    }

    {
        System.out.println("This is Child's no-static block");
    }

    People getFriend(String name) {
        String newName = name + "Potter";
        // 局部内部类的成员是不能够在方法外部被访问的
        class Friend extends People {
            final String name = newName;
            int age = 0;
        }
        return new Friend();
    }


}

public class Test {
    public static void main(String[] args) throws Exception {
        Child child = new Child();
        child.test();
        child.myFunction();
        System.out.println(Math.ceil(0D));
        System.out.println(Math.ceil(-0D));
//        Integer.valueOf(10).intValue();
//        System.out.println(System.getProperty("line.separator"));
//        // 使用这种方式可以获取当前系统文本文件的换行符，Windows为\r\n，Unix为\n
        System.out.println(child.getFriend("Tom"));
        System.out.println(child.getFriend("Alise"));
    }
}
