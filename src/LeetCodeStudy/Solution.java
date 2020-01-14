package LeetCodeStudy;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new LeetCode1042_1().gardenNoAdj(3,
                new int[][]{
                        {1, 2}, {2, 3}, {3, 1}
                })));
        System.out.println(Arrays.toString(new LeetCode1042_1().gardenNoAdj(4,
                new int[][]{
                        {1, 2}, {3, 4}
                })));
        System.out.println(Arrays.toString(new LeetCode1042_1().gardenNoAdj(4,
                new int[][]{
                        {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}
                })));
    }
}
