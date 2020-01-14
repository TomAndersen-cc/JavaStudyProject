package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2020/1/11
 * @Version
 * @Description
 */
public class LeetCode11_2 {
    // 使用“双指针法”求解
    // 双指针原理：一开始判断最大范围的左右两个指针，然后移动其中一个指针。当将大指针向内移动时，距离是一定减小
    // 的，而两个指针中最小的值不一定会变，若最小值不变则由于距离减小那么围成的面积也减小，若最小值更新了即当前
    // 最小值比之前还小，那么依旧是围成的面积变小。因此将两边指针向中间移动时，只能将两边中指针较小的向内进行移
    // 动，这样才能保证两指针围成的面积有可能朝着增大的方向移动
    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else j--;
        }
        return max;
    }
}
