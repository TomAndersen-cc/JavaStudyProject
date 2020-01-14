package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2020/1/11
 * @Version
 * @Description
 */
public class LeetCode11 {
    // 暴力求解，原本是想使用“单指针”方式减少运算量，但是由于增加了过多的判断导致比直接暴力求解的方式还要来
    // 得慢，这种方式真的太蠢了
    public int maxArea(int[] height) {
        int max = 0, len = height.length;
        for (int i = 0; i < len - 1; i++) {
            int sign = len - 1;
            int tmp = (sign - i) * Math.min(height[i], height[sign]);
            max = Math.max(tmp, max);
            for (int j = len - 2; j > i; j--) {
                if (height[j] > height[sign]) {
                    tmp = (j - i) * Math.min(height[i], height[j]);
                    sign = Math.max(j, sign);
                    max = Math.max(tmp, max);
                }
            }
        }
        return max;
    }
}
