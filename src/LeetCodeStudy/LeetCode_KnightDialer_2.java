package LeetCodeStudy;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author Tom Andersen
 * @Version 0.2
 * @Date 2019/10/6
 * @Result Time Limit Exceeded!!!
 */
//再次出现结果正确，却时间超时的情况，只懂得理论，却不会实践的傻子！！！
//注意在编程比赛时不要出现大量操作数据结构的情况，具体问题具体分析
public class LeetCode_KnightDialer_2 {
    private final static int[] numOfNextNode = {2, 2, 2, 2, 3, 0, 3, 2, 2, 2};
    private final static int[][] nextNodeIndex = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7},
            {2, 6}, {1, 3}, {2, 4}};

    //使用的是多叉树层次遍历的思想，在此题目场景下效率很低，因为使用了队列
    public int knightDialer(int N) {
        int sum = 0;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        if (N > 1) {
            for (int i = 0; i < 10; i++) {
                queue.offer(i);
            }
            int Length = 10;
            while (N-- > 2) {
                int numOfLevel = 0;
                while (Length-- > 0 && !queue.isEmpty()) {
                    int index = queue.poll();
                    numOfLevel += nextNodeIndex[index].length;
                    for (int nextIndex : nextNodeIndex[index]) {
                        queue.offer(nextIndex);
                    }
                }
                Length = numOfLevel;
            }
            while (!queue.isEmpty()) {
                sum += numOfNextNode[queue.poll()];
            }
        } else if (N == 1) {
            sum = 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_KnightDialer_2().knightDialer(1));
        System.out.println(new LeetCode_KnightDialer_2().knightDialer(2));
        System.out.println(new LeetCode_KnightDialer_2().knightDialer(3));
    }
}
