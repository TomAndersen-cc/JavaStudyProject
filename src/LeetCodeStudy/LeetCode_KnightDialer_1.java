package LeetCodeStudy;


/**
 * @Author Tom Andersen
 * @Version 0.1
 * @Date 2019/10/6
 * @Result 	Time Limit Exceeded!!!
 */
/*
Title: 935. Knight Dialer.
 */
//注意在实际编程比赛中不允许使用递归的方式求解，因为太费时间了！！！
public class LeetCode_KnightDialer_1 {
    private final static int[] numOfNextNode = {2, 2, 2, 2, 3, 0, 3, 2, 2, 2};
    private final static int[][] nextNodeIndex = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7},
            {2, 6}, {1, 3}, {2, 4}};
    //采用的是问题分解的思想，但在此程序递归中，重复计算太多，因该用数组存储子问题解，便于后续计算
    private int Calculate(int K, int index) {
        if (K == 1) {
            return numOfNextNode[index];
        } else {
            int sum = 0;
            for (int pos : nextNodeIndex[index]) {
                sum += Calculate(K - 1, pos);
            }
            return sum;
        }
    }

    public int knightDialer(int N) {
        int sum = 0;
        if (N == 1) sum = 10;
        else if (N > 1) {
            for (int i = 0; i < 10; i++) {
                sum += Calculate(N - 1, i);
            }
        }
        //题目要求取模
        return sum%(1000000007);
    }
    public static void main(String[] args){
        int N_1= 1;
        int N_2= 2;
        int N_3= 3;

        System.out.println(new LeetCode_KnightDialer_1().knightDialer(N_1));
        System.out.println(new LeetCode_KnightDialer_1().knightDialer(N_2));
        System.out.println(new LeetCode_KnightDialer_1().knightDialer(N_3));
    }
}
