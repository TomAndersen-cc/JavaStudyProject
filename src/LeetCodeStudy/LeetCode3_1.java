package LeetCodeStudy;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author TomAndersen
 * @Date 2019/12/25
 * @Version
 * @Description Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LeetCode3_1 {
    // 返回最大子串长度
    // 基于LinkedList实现滑动窗口策略
    static int lengthOfLongestSubstring(String s) {
        int length = 1;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            length = Math.max(length, queue.size());
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
