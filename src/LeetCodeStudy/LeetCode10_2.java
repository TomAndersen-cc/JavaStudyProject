package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/29
 * @Version
 * @Description
 */
public class LeetCode10_2 {
    // 子问题的解矩阵
    private boolean[][] dp;// boolean类型矩阵的初值默认为false
    // dp[i][j]代表text[:i+1]与pattern[:j+1]是否匹配

    // 使用DP的方式求解(Dynamic Processing)——自底向上（即由子问题引出父问题）
    public boolean isMatch(String text, String pattern) {
        dp = new boolean[text.length() + 1][pattern.length() + 1];
        // 显然dp[0][0]为true
        dp[0][0] = true;
        // 计算dp[0][:]，其中dp[1:][0]都为默认值false
        for (int i = 1; i <= pattern.length(); i++) {
            dp[0][i] = pattern.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        // 计算dp[1:][1:]
        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == '*') {
                    if (text.charAt(i - 1) == pattern.charAt(j - 2) ||
                            pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                        // 以上三种情况分别代表：a*表示aa、a*、null的情况
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (pattern.charAt(j - 1) == '.'
                        || text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

}
