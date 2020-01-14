package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2020/1/1
 * @Version
 * @Description
 */
public class LeetCode672_1 {
    // 将操作①②③④的次数分别设置为abcd，则各灯泡状态分别为：
    // light1 = 1+a+c+d
    // light2 = 1+a+b
    // light3 = 1+a+c
    // light4 = 1+a+b+d
    // light5 = 1+a+c
    // light6 = 1+a+b
    // 即:
    // light4 = light1+light2+light3
    // light5 = light3
    // light6 = light2
    // 故前面3个灯泡的状态决定了整个灯牌状态序列，只需考虑前面3者的状态即可
    // 将所有可能的状态列出，依照条件返回即可

    // 说实话这题目原题给我，我也不会
    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) return 0;
        if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        // (m,n)=(1,1)(1,2)(1,3)时的最终状态数分别为2,3,4
        if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        // (m,n)=(2,1)(2,2)(2,3)时的最终状态数分别为2,4,7
        return n == 1 ? 2 : n == 2 ? 4 : 8;
        // (m,n)=(3,1)(3,2)(3,3)时的最终状态数分别为2,4,8
        // 暂时还不懂为什么m>3时和m=3的情况是一样的
    }
}
