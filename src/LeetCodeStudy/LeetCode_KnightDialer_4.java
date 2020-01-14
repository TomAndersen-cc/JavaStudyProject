package LeetCodeStudy;

import java.util.Arrays;

/**
 * @Author Tom Andersen
 * @Version 0.4
 * @Date 2019/10/7
 * @Result Failed
 */
//可以尝试使用无向图邻接矩阵自乘运算的方式计算路径长度为N下各个点的可能路径数，然后求和即可
//结果不可行，在Java中缺少基本数据类型的矩阵运算类和方法，需要自行实现或者引用第三方包，对于此题使用此方法
// 实在是不合适（放弃）
public class LeetCode_KnightDialer_4 {
    private static int mod = (int) (1e9+7);
    public int knightDialer(int N) {
        long[][] M = {
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}
        };
        long[][] res = new long[10][10];
        int sum = 0;
        if (N % 2 == 1) {
            matrixCopy(M, res);
        }
        while (N > 0) {
            N /= 2;
            M = matrixMultiply(M,M);
        }
        //未写完
        //未写完
        //未写完
        //未写完
        //未写完

        return sum;
    }

    //对两个矩阵进行乘法运算
    public static long[][] matrixMultiply(long[][] x, long[][] y) {
        //默认矩阵都是N*N，时间复杂度为N*N*N
        int N = x.length;
        long[][] M = new long[N][N];
        //注意不能使用clone函数，clone函数针对二维数组实际上是浅拷贝
        //long[][] M = x.clone();
        int sum = 0;
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    sum += x[j][i] * y[i][k];
                }
                M[j][k] = sum;
                sum = 0;
            }
        }
        return M;
    }

    //计算矩阵的元素之和
    public static long matrixsum(long[][] M) {
        long sum = 0;
        for (long[] x : M) {
            for (long y : x) {
                sum += y;
            }
        }
        return sum;
    }

    //拷贝矩阵
    public static boolean matrixCopy(long[][] x, long[][] y) {
        if (x.length != y.length) return false;
        else {
            for (int i = 0; i < x.length; i++) {
                y[i] = x[i].clone();
            }
        }
        return true;
    }


    public static void main(String[] args) {

        long[][] x = {{1, 2}, {2, 1}};
        //注意在创建多维数组时要声明这个数组的长度，即最外层维度
        long[][] y = new long[2][];
        matrixCopy(x, y);
        for (long[] element : y) {
            System.out.println(Arrays.toString(element));
        }

    }
}
