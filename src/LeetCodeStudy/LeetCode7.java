package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 */
class LeetCode7 {
    // 面对数字使用字符串操作，这是最蠢的。。。当前方法真实蠢哭了
    static int reverse(int x) {
        char[] s = String.valueOf(x).toCharArray();
        char tmp;
        int len = s.length;
        if (-9 <= x && x <= 9) {
            return x;
        }
        if (x > 0) {
            for (int i = 0; i < len / 2; i++) {
                tmp = s[i];
                s[i] = s[len - i - 1];
                s[len - i - 1] = tmp;
            }
        } else {
            for (int i = 1; i < len / 2 + 1; i++) {
                tmp = s[i];
                s[i] = s[len - i];
                s[len - i] = tmp;
            }
        }
        long m = Long.valueOf(new String(s));
        if (m > Integer.MAX_VALUE || m < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) m;
        }
    }
}
