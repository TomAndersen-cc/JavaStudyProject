package LeetCodeStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TomAndersen
 * @Date 2020/1/2
 * @Version
 * @Description Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
class LeetCode784 {
    // 从解决方案上来看此方法属于BFS方法的一种，但不是使用Queue队列来实现的而是
    // 使用ArrayList动态数组来实现
    public List<String> letterCasePermutation(String S) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                int size = arrayList.size();
                for (int j = 0; j < size; j++) {
                    String tmp = arrayList.get(j);
                    char[] chars = tmp.toCharArray();
                    char a = Character.isUpperCase(S.charAt(i)) ?
                            Character.toLowerCase(tmp.charAt(i)) :
                            Character.toUpperCase(tmp.charAt(i));
                    chars[i] = a;
                    // 也可以使用以下代码，但是使用substring的方法就是直接创建String字符串相比于
                    // 直接操作数组效率会低很多
                    /*arrayList.add(tmp.substring(0, i - 1) + a +
                            tmp.substring(i + 1, tmp.length() - 1));*/
                    arrayList.add(new String(chars));
                }
            }
        }
        return arrayList;
    }
}
