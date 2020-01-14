package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description
 */
public class LeetCode8 {
    public int myAtoi(String str) {
        long m = 0;
        int sign = 1;
        str = str.trim();// 去除前导0和尾部0
        if (str.isEmpty()) return 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-'
                || Character.isDigit(str.charAt(0))) {
            if (str.charAt(0) == '-') {
                sign = -1;
                str = str.substring(1);
            } else if (str.charAt(0) == '+') {
                str = str.substring(1);
            }
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    m *= 10;
                    m += str.charAt(i) - '0';
                    if (m > Integer.MAX_VALUE) {
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                } else break;
            }
            return (int) m * sign;
        } else return 0;
    }
}
