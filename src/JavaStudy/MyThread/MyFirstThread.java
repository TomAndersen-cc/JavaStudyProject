package JavaStudy.MyThread;

public class MyFirstThread extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println("This is my first thread");
    }
}
