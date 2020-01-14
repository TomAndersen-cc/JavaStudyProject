package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/31
 * @Version
 * @Description
 */
public class LeetCode10_3 {
    // 使用DP的方式求解(Dynamic Processing)——自底向上（即由子问题引出父问题）
    // 和上一个解法有些不同

    boolean dp[][];// 子问题的解矩阵
    // dp[i][j]表示字符串text[i:]与pattern[j:]是否匹配

    public boolean isMatch(String text, String pattern) {
        dp = new boolean[text.length() + 1][pattern.length() + 1];
        // 显然dp[text.length()][pattern.length()] = true
        dp[text.length()][pattern.length()] = true;
        // 显然dp[:text.length()][pattern.length()] = false
        // 故j是从pattern.length() - 1开始递减
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = i < text.length() && (text.charAt(i) == pattern.charAt(j)
                        || pattern.charAt(j) == '.');
                if (first_match) {
                    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                } else if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                }
            }
        }
        return dp[0][0];
    }
}
