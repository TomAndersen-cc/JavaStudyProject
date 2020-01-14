package LeetCodeStudy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Author TomAndersen
 * @Date 2020/1/12
 * @Version
 * @Description
 */
public class LeetCode1042 {
//     主要思想：遍历节点数组，每次遇到一个节点，观察其前面与之相邻的节点，排除这些节点所具有的颜色
//     在剩下的颜色中找到最靠前的颜色的值（即最小值）
//     本例中使用的是邻接矩阵的方式表示图，所以会浪费额外的空间，同时由于是个稀疏矩阵，所以在遍历的时候
//     同样会花费很多时间，与邻接表相比查找速度快，但遍历速度就很慢了
    public int[] gardenNoAdj(int N, int[][] paths) {
        boolean[][] matrix = new boolean[N][N];// 用于记录花园间可达性
        int[] ans = new int[N];// 用于记录各个花园种植花的种类
        for (int[] tmp : paths) {
            matrix[tmp[0] - 1][tmp[1] - 1] = true;
            matrix[tmp[1] - 1][tmp[0] - 1] = true;
        }
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[]{1, 2, 3, 4};
            for (int j = i - 1; j >= 0; j--) {
                if (matrix[i][j]) tmp[ans[j] - 1] = 0;
            }
            int sign = 0;
            while (tmp[sign] == 0) sign++;
            ans[i] = tmp[sign];
        }
        return ans;
    }
}
