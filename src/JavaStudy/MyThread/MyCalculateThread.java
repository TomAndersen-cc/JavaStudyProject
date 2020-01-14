package JavaStudy.MyThread;

public class MyCalculateThread extends Thread {
    private int start = 0, end = 0;
    private long total = 0;

    public MyCalculateThread(int x, int y) {
        super();
        this.start = x;
        this.end = y;
    }

    @Override
    public void run() {
        super.run();
        //以下是自定义部分
        for (int i = start; i <= end; i++) {
            total += i;
        }
    }

    public long getTotal() {
        return total;
    }
}
