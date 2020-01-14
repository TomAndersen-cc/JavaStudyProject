package LeetCodeStudy;

import java.util.*;

/**
 * @Author TomAndersen
 * @Date 2020/1/12
 * @Version
 * @Description
 */
public class LeetCode1042_1 {
    // 使用邻接表的方式来表示图进行求解，主要思想和之前一样
    public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>(); // 用于表示图
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        int[] ans = new int[N]; // 用于存放结果
        for (int[] tmp : paths) {
            graph.get(tmp[0] - 1).add(tmp[1] - 1);
            graph.get(tmp[1] - 1).add(tmp[0] - 1);
        }
        for (int i = 0; i < N; i++) {
            boolean[] colors = new boolean[5];
            for (int j : graph.get(i)) {
                colors[ans[j]] = true;
            }
            int type = 1;
            while (colors[type]) type++;
            ans[i] = type;
        }
        return ans;
    }
}
