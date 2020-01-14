package LeetCodeStudy;

/**
 * @Author
 * @Version
 * @Date 2019/10/8
 */
//使用动态规划的方式求解，使用矩阵记录解（相比于之前使用更多的空间，但是更简单明了）
//动态规划问题的两个特征：1.最优子结构(也可以只是子结构，即下一步由之前结果推导而来) 2.子问题解集重叠
public class LeetCode_KnightDialer_5 {
    public int knightDialer(int N) {
        //矩阵Path用于存储过程中的子问题解
        long[][] Path = new long[N][N];
        int sum = 0;

        return sum;
    }
}
