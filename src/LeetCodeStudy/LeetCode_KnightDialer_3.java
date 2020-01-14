package LeetCodeStudy;

import java.util.Arrays;

/**
 * @Author Tom Andersen
 * @Version 0.3
 * @Date 2019/10/6
 * @Title KnightDialer
 * @Result Succeeded
 */
//可以尝试使用动态规划(Dynamic Programing)的思想(自底向上)求解:
    /*
    当N=1时：
        f(0,N)=f(1,N)=f(2,N)=......=f(9,N)=1
    当N>1时：
        f(0,N)=f(4,N-1)+f(6,N-1)
        f(1,N)=f(6,N-1)+f(8,N-1)
        f(2,N)=f(7,N-1)+f(9,N-1)
        f(3,N)=f(4,N-1)+f(8,N-1)
        f(4,N)=f(3,N-1)+f(9,N-1)
        f(5,N)=0
        f(6,N)=f(1,N-1)+f(7,N-1)+f(0,N-1)
        f(7,N)=f(2,N-1)+f(6,N-1)
        f(8,N)=f(1,N-1)+f(3,N-1)
        f(9,N)=f(2,N-1)+f(4,N-1)
     */
public class LeetCode_KnightDialer_3 {
    //使用long类型避免数据量过大而造成数据超过int长度限制而溢出
    private long[] firstMove = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private long[] followMove = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    //注意:当数据过大超过int的容量时，值就变得不能确定，所以按照题目的要求是没错的，每次的结果与10e9+7作取模运算
    public int knightDialer(int N) {
        int sum = 0;
        final int mod = (int) (1E9 + 7);
        while (N-- > 1) {
            followMove[0] = (firstMove[4] + firstMove[6]) % mod;
            followMove[1] = (firstMove[6] + firstMove[8]) % mod;
            followMove[2] = (firstMove[7] + firstMove[9]) % mod;
            followMove[3] = (firstMove[4] + firstMove[8]) % mod;
            followMove[4] = (firstMove[3] + firstMove[9] + firstMove[0]) % mod;
            followMove[5] = 0;//在5处骑士走不动，只会有初试位置，故当需要走N步(N>1)时，不可达
            followMove[6] = (firstMove[1] + firstMove[7] + firstMove[0]) % mod;
            followMove[7] = (firstMove[2] + firstMove[6]) % mod;
            followMove[8] = (firstMove[1] + firstMove[3]) % mod;
            followMove[9] = (firstMove[2] + firstMove[4]) % mod;
            firstMove = followMove.clone();
            //System.out.println(N + " " + Arrays.toString(firstMove));
        }
        for (long num : firstMove) {
            sum += num;
            sum = sum % mod;
        }
        return sum;
    }

    public static void main(String[] args) {

        /*System.out.println(new LeetCode_KnightDialer_3().knightDialer(1));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(2));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(3));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(4));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(5));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(50));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(110));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(112));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(115));
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(120));*/
        System.out.println(new LeetCode_KnightDialer_3().knightDialer(161));

    }
}
