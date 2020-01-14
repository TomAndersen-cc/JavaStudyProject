package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description
 */
public class LeetCode5_1 {
    private static int start = 0, end = 0;

    static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            findPalindrome(s, i, i + 1);
            findPalindrome(s, i, i);
        }
        return s.substring(start, end + 1);
    }

    // 用于向两边检查是否属于回文
    private static void findPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;j++;
        }
        i++;j--;// 回到最大回文子串位置
        // 只需要在最后一步更新即可
        if ((j - i) > (end - start)) {
            start = i;
            end = j;
        }
    }
}
