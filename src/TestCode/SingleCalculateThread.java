package TestCode;

public class SingleCalculateThread {
    public static void main(String[] args) {
        long  total = 0L;
        //必须使用long类型否则不够精确
        long StartTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000000; i++) {
            total += i;
        }
        long EndTime = System.currentTimeMillis();
        System.out.println(total);
        System.out.println("总耗时: "+(EndTime - StartTime+"ms"));
    }
}
