package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/26
 * @Version
 * @Description Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LeetCode5 {
    static String longestPalindrome(String s) {
        int start = 0, end = 0;// 用于记载最长回文子串位置
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 1; i < len; i++) {
            int p = 1;
            // 先考虑奇数情况
            while (i - p >= 0 && i + p < len) {
                if (s.charAt(i - p) == s.charAt(i + p)) {
                    if ((2 * p + 1) > (end - start + 1)) {
                        start = i - p;
                        end = i + p;
                    }
                    p++;
                } else break;
            }
            // 再考虑偶数情况
            int q = 1;
            while (i - q >= 0 && i + q - 1 < len) {
                if (s.charAt(i - q) == s.charAt(i + q - 1)) {
                    if (q * 2 > (end - start + 1)) {
                        start = i - q;
                        end = i + q - 1;
                    }
                    q++;
                } else break;
            }
        }
        return s.substring(start, end+1);
    }
}
