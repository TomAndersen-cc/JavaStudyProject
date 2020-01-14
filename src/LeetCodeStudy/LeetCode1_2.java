package LeetCodeStudy;
/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Tom Andersen
 * @Version 0.2
 * @Date 2019/10/3
 * @Result Failure
 */
public class LeetCode1_2 {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myNums = new TreeMap<>();
        int[] index = {-1, -1};
        int i = 0;
        for (int num : nums) {
            myNums.put(num, i++);
        }
        int tmp_key, tmp_value;
        //使用Iterator迭代器进行遍历，只有这种遍历方式支持在遍历过程中删除表中与元素
        Iterator<Map.Entry<Integer, Integer>> entries = myNums.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            tmp_key = entry.getKey();
            tmp_value = entry.getValue();
            entries.remove();
            if (myNums.containsKey(target - tmp_key)) {
                index[0] = tmp_value;
                index[1] = myNums.get(target - tmp_key);
                break;
            }
        }
        /*
        //使用foreach(增强型循环)遍历Map，但这种方式不允许在遍历过程中修改Map长度
        for (Integer key : myNums.keySet()) {
            tmp_key = key;
            tmp_value = myNums.get(key);
            myNums.remove(tmp_key);
            if (myNums.containsKey(target - tmp_key)) {
                index[0] = tmp_value;
                index[1] = myNums.get(target - tmp_key);
                break;
            }
        }
        */
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 5};
        int target = 4;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
