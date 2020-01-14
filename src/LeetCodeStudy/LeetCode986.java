package LeetCodeStudy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author TomAndersen
 * @Date 2020/1/12
 * @Version
 * @Description
 */
public class LeetCode986 {
    // 这道题直接解决即可
    // 两个指针i，j向后移动的策略是谁的尾巴在前面谁下次向后移动
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int i = 0, j = 0, lenA = A.length, lenB = B.length;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[][] ans;
        while (i < lenA && j < lenB) {
//            int[] intersection;
            int m = Math.max(A[i][0], B[j][0]);
            int n = Math.min(A[i][1], B[j][1]);
//            intersection = m <= n ? new int[]{m, n} : null;
//            if (intersection != null) arrayList.add(intersection);
            if (m <= n) arrayList.add(new int[]{m, n});// 代码优化
            if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        ans = new int[arrayList.size()][];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = arrayList.get(k);
        }
        return ans;
    }

//    private int[] getIntersection(int[] a, int[] b) {
//        if (a.length != 2 || b.length != 2) return null;
//        int[] intersection;
//        int m = Math.max(a[0], b[0]);
//        int n = Math.min(a[1], b[1]);
//        intersection = m < n ? new int[]{m, n} : null;
//        return intersection;
//    }
}
