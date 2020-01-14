package LeetCodeStudy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author TomAndersen
 * @Date 2019/12/31
 * @Version
 * @Description There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 * <p>
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * <p>
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 * <p>
 * Example 1:
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * Example 2:
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 */
public class LeetCode672 {
    // n为灯泡数，m为随机操作数
    public int flipLights(int n, int m) {
        // 用于存放灯泡状态，因为灯泡状态是使用位图来表示，所以存储类型是Integer
        Set<Integer> status = new HashSet<>();
        // 当灯泡数大于6个时，从第7个开始就是重复前面的1-6灯泡的状态，所以每次操作的时候
        // 我们都当成6个灯泡来处理，当n小于6时则将位图向后移动6-n位即可得到前n位的结果
        int move = n >= 6 ? 0 : 6 - n;
        // 当操作序列中同一种操作存在偶数次时，不论序列如何排列，其对最后的结果都没有影响
        // 因为偶数次的同一操作会相互抵消，所以每种操作要想生效要么为0次要么为1次，一共4种
        // 操作，因此一共有16种可能，用位图即整数i来表示操作，operate的二进制表示中1的位置则表示
        // 对对应位置的开关操作一次，0则不操作,operate的二进制为4bit
        for (int operate = 0; operate < 16; operate++) {
            // 取出i的二进制表示中1的个数
            int bitcount = Integer.bitCount(operate);
            // 当m为偶数时，其操作序列形成的位图中，1的个数只能为0,2,4,6这四种情况
            // 当m为奇数时，其操作序列形成的位图中，1的个数只能为1,3,5这三种情况
            // 故利用以下判断便能过滤出m次操作所能产生的操作序列
            if (bitcount % 2 == m % 2 && bitcount <= m) {
                // 然后按照操作序列中1对应的位置对灯泡进行操作
                int state = 0;
                if ((operate & 1) > 0) {
                    state ^= 0b111111;// 对应操作①
                }
                if ((operate >> 1 & 1) > 0) {
                    state ^= 0b010101;// 对应操作②
                }
                if ((operate >> 2 & 1) > 0) {
                    state ^= 0b101010;// 对应操作③
                }
                if ((operate >> 3 & 1) > 0) {
                    state ^= 0b100100;// 对应操作④
                }
                state = state >> move;// 当n<6时，取前面n个灯泡的状态，否则取前6个
                status.add(state);// 添加状态，由于Set的性质，其中无重复状态
            }
        }
        return status.size();
    }
}
