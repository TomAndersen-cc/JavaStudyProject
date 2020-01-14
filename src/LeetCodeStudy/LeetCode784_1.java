package LeetCodeStudy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author TomAndersen
 * @Date 2020/1/8
 * @Version
 * @Description
 */
class LeetCode784_1 {
    // 使用DFS方法来求解此题
    // 深度遍历，每次遇到英文字母时将其置为小写，然后继续深度遍历，遍历左子树之后再置为大写，继续
    // 遍历右子树
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new LinkedList<>();
        DFS(ans, S.toCharArray(), 0);
        return ans;
    }

    private void DFS(List<String> ans, char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
        } else if (Character.isLetter(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
            DFS(ans, chars, index + 1);
            chars[index] = Character.toUpperCase(chars[index]);
            DFS(ans, chars, index + 1);
        } else DFS(ans, chars, index + 1);
    }
}
