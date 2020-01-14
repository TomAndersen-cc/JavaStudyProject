package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/26
 * @Version
 * @Description
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 */
public class LeetCode4 {
    // 这是最优解，居然是自己写的，不敢相信
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, cursor = 0;
        double a = 0, b = 0, half = (double) (m + n) / 2;
        while (cursor++ <= half) {
            a = b;
            if (i < m && j < n) {
                if (nums1[i] > nums2[j]) {
                    b = nums2[j++];
                } else {
                    b = nums1[i++];
                }
            } else {
                if (i < m) {
                    b = nums1[i++];
                } else {
                    b = nums2[j++];
                }
            }
        }
        return (m+n) % 2 == 0 ? (a + b) / 2 : b;
    }
}
