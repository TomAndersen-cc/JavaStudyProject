package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2020/1/11
 * @Version
 * @Description
 */
public class LeetCode11_1 {
    // 使用暴力求解方式
    public int maxArea(int[] height) {
        int max = 0, len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }
}
