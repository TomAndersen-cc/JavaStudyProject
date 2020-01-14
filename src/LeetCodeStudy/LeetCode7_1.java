package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description
 */
class LeetCode7_1 {
    static int reverse(int x) {
        long m = 0;
        while (x != 0) {
            m = m * 10 + x % 10;
            x /= 10;
        }
        if (m < Integer.MIN_VALUE || m > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) m;
        }
    }
}
