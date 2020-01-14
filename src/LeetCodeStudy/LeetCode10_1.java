package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/28
 * @Version
 * @Description
 */
public class LeetCode10_1 {
    // 因为此问题的方法有重叠子问题（最优子结构），因此自然可以使用dp方式进行求解
    // 可以通过绘制矩阵图来证得此问题有重叠子结构，自然可以使用DP求解，并使用数组存放子问题解
    // DP算法的一个重要标志就是使用数组存储子问题的解，便于为父问题快速提供子问题解
    // 使用DP的方式求解(Dynamic Processing)——自顶向下（即由父问题进入子问题）
    enum Result {
        TRUE, FALSE
    }

    // 子问题的解矩阵
    private boolean[][] matrix;// boolean类型矩阵的初值默认为false

    private Result[][] answers;// 自定义类型矩阵的初值为null


    public boolean isMatch(String text, String pattern) {
        // 注意动态申请的数组默认值为false
        // answers[i][j]表示text[i:]与pattern[j:]是否匹配
        matrix = new boolean[text.length() + 1][pattern.length() + 1];
        return dp(text, pattern, 0, 0);
    }

    // 此函数用于判断text从i开始的子串和pattern从j开始的子串是否匹配
    private boolean dp(String text, String pattern, int i, int j) {
        // 如果当前问题之前已经有了答案,则直接返回结果
        if (answers[i][j] != null) {
            return answers[i][j] == Result.TRUE;
        }

        boolean ans = false;
        // 如果pattern已经匹配到尾部
        if (j == pattern.length()) {
            ans = (i == text.length());
        } else {
            // 判断text[i:]和pattern[j:]第一个字符是否匹配
            boolean first_match = (i != text.length()) &&
                    (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
            // 如果没有到尾部且pattern[j+1]为'*'
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                // 如果text[i]与pattern[j]匹配成功，继续匹配text[i+1]与pattern[j]
                // 否则跳过2个字符，对text[i:]与pattern[j+2:]进行匹配

                ans = (first_match && dp(text, pattern, i + 1, j) ||
                        dp(text, pattern, i, j + 2));
            } else {
                // 如果第二个字符不是'*'，则看第一个字符是否匹配，如果匹配则看下一步子串
                ans = first_match && dp(text, pattern, i + 1, j + 1);
            }
        }
        answers[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
