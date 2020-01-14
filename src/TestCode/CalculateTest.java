package TestCode;

import JavaStudy.MyThread.MyCalculateThread;

import java.util.ArrayList;
import java.util.List;

public class CalculateTest {
    public static void main(String[] args) {
        List<MyCalculateThread> myThreads = new ArrayList<MyCalculateThread>();
        long total = 0;
        long StartTime = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            MyCalculateThread myThread = new MyCalculateThread(
                    i * 25000000 + 1, (i + 1) * 25000000);
            myThread.start();
            myThreads.add(myThread);
        }

        for (MyCalculateThread myThread : myThreads) {
            //使用join等待此进程结束必须要处理InterruptedException异常
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            total += myThread.getTotal();
        }
        long EndTime = System.currentTimeMillis();
        System.out.println(total);
        System.out.println("总耗时: " + (EndTime - StartTime + "ms"));
    }
}
