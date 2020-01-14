package LeetCodeStudy;

import java.util.Arrays;
import java.util.HashMap;

/*
  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  <p>
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  <p>
  Example:
  <p>
  Given nums = [2, 7, 11, 15], target = 9,
  <p>
  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
 */

/**
 * @Author Tom Andersen
 * @Version 0.1
 * @Date 2019/10/3
 * @Result Success
 */
public class LeetCode1_1 {
    private static int[] twoSum(int[] nums, int target) {
        //HashMap中键值对的位置是根据Key的HashCode计算所得，基本属于随机的，所以是无序的
        HashMap<Integer, Integer> _nums = new HashMap<>();
        int i = 0;
        int[] index = {-1, -1};
        //获取数据
        for (int num : nums) {
            //用Key存索引，Value存数据(若反过来不适应原始数组中有两个相同数的情况，因为HashMap中的Key值不能重复)
            _nums.put(i++, num);
        }
        //处理数据
        int value;
        for (i--; i >= 0; i--) {
            value = _nums.get(i);
            _nums.remove(i);//每次取出一个数，避免当原始数组中有两个相同元素时返回错误index
            if (_nums.containsValue(target - value)) {
                index[0] = i;
                int lest = target - value;
                for (i--; i >= 0; i--) {
                    if (_nums.get(i) == lest) {
                        index[1] = i;
                    }
                }
                break;
            }
        }
        //返回数据
        return index;
    }

    //TestCode
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
