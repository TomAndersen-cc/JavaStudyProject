package LeetCodeStudy;

/**
 * @Author TomAndersen
 * @Date 2019/12/27
 * @Version
 * @Description Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 */
public class LeetCode10 {

    // 使用创建有穷自动机的方式进行求解不成功（暂时不知道咋办，试了好几次但是总是有bug）
    // 换一种思路，使用递归方式求解(recursive solution)
    public boolean isMatch(String s, String p) {
        // 如果pattern为空，看string是否为空，同时为空则匹配，string不为空则不匹配
        if (p.isEmpty()) return s.isEmpty();
        // 观察第一个字符是否相互匹配
        boolean first_match = (!s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        // 若pattern长度大于等于2且第二个字符为'*'，则：
        // ①若第一个字符相互匹配,则看后续字符是否能继续匹配
        // ②若第一个字符不相互匹配,则尝试跳过这个模式字符和'*'的组合,看之后是否能匹配
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (first_match && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        }
        // 若第一个字符不匹配则返回false
        // 若两者第一个字符匹配则检查下一个待查字符和下一个模式字符
        return first_match && isMatch(s.substring(1), p.substring(1));
    }
}
