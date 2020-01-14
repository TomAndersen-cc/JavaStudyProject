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
import java.util.HashMap;
import java.util.Map;

/**
 * @Author TomAndersen
 * @Date 2019/10/3
 * @Version 0.3
 * @Result The Best!
 */
public class LeetCode1_3 {
    private static int[] twoSum(int[] nums, int target) {
        int[] index = {0, 1};
        if (nums.length > 2) {
            Map<Integer, Integer> myMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                //可以将Map看做是一个Stack，当当前元素不能与前面的元素形成target时，则将元素压入Map中，等待后续匹配
                if (myMap.containsKey(target - nums[i])) {
                    //如果Map中配对成功则记录index然后返回
                    index[0] = myMap.get(target - nums[i]);
                    index[1] = i;
                    break;
                } else {
                    //如果配对不成功，则将当前元素压入Map中
                    myMap.put(nums[i], i);
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums_1 = {2, 11, 7, 15};
        int[] nums_2 = {2, 2, 5, 6};
        int target_1 = 9;
        int target_2 = 4;
        System.out.println(Arrays.toString(nums_1));
        System.out.println(Arrays.toString(nums_2));
        System.out.println(Arrays.toString(twoSum(nums_1, target_1)));
        System.out.println(Arrays.toString(twoSum(nums_2, target_2)));
    }
}
