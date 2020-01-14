package TestCode;

import JavaStudy.MyThread.*;

public class ThreadRunTest {
    public static void main(String[] args) {
        MyFirstThread mythread = new MyFirstThread();
        mythread.start();
        System.out.println("运行结束！");
        //可以发现MyfirstThread中的run方法执行较晚，说明多线程编程中代码的执行结果与代码的顺序是无关的
    }
}
