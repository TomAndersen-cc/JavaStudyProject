package LeetCodeStudy;

import java.util.HashMap;

/**
 * @Author TomAndersen
 * @Date 2019/12/26
 * @Version
 * @Description
 */
public class LeetCode3_2 {
    // 基于HashMap实现滑动窗口策略
    static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int length = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        // s中从j到i为最大子串
        for(int i=0,j=0;i<s.length();i++){
            //j = Math.max(map.getOrDefault(s.charAt(i),j),j);
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            length = Math.max(length,i-j+1);
        }
        return length;
    }
}
