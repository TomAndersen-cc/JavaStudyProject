package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2020/1/12
 * @Version
 * @Description 一道阿里面试编程题目：将一个圆形等分成N个小扇形，将这些扇形标记为1，2，3,…，N。现在使用M种颜色对每个
 * 扇形进行涂色，每个扇形涂一种颜色，且相邻的扇形颜色不同,问有多少种不同的涂法?（N≥1，M≥3）
 */
public class SectorPaint {
    // 主要是在穷举前面几种答案过程找到其中的规律，详见 https://blog.csdn.net/THmen/article/details/79529355
    // 使用穷举+递归的方式进行求解比较直观
    // m表示颜色种类数，n表示等分的扇形个数
    public static int Calculate(int m, int n) {
        if (n < 1 || m < 3) return 0;
        if (n == 2) return m * (m - 1);
        if (n == 3) return m * (m - 1) * (m - 2);
        if (n == 4) return m * (m - 1) * (m - 1 + (m - 2) * (m - 2));
        else return (m - 1) * Calculate(m, n - 1);
    }

    // 当然也可以不使用递归
    public static int Calculate1(int m, int n) {
        if (n < 1 || m < 3) return 0;
        if (n == 2) return m * (m - 1);
        if (n == 3) return m * (m - 1) * (m - 2);
        if (n == 4) return m * (m - 1) * (m * m - 3 * m + 3);
        else return (int) (m * Math.pow(m - 1, n - 3) * (m * m - 3 * m + 3));
    }

    public static void main(String[] args) {
        System.out.println(Calculate1(4, 4));// 84
        System.out.println(Calculate1(4, 5));// 252
        System.out.println(Calculate1(3, 6));// 72

        System.out.println(Calculate(4, 4));// 84
        System.out.println(Calculate(4, 5));// 252
        System.out.println(Calculate(3, 6));// 72
    }
}
