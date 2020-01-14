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
//使用“分治法”思想求解

import java.util.Arrays;

/**
 * @Author TomAndersen
 * @Version 0.4
 * @Date 2019/10/4
 * @Result 使用分治法求解
 */
public class LeetCode1_4 {
    private int[] index = {0, 1};
    private int[] nums;
    private int target;
    private int start, end;

    public LeetCode1_4(int[] nums_1, int target_1) {
        this.nums = nums_1;
        this.target = target_1;
        this.start = 0;
        this.end = nums_1.length - 1;
    }

    public void twoSum(int start, int end) {
        if (end - start > 2) {
            int mid = (end - start) / 2;
            twoSum(start, mid);
            twoSum(mid + 1, end);
            for (int i = start; i < mid; i++) {
                for (int j = mid; j <= end; j++) {
                    if (nums[i] + nums[j] == target) {
                        index[0] = i;
                        index[1] = j;
                    }
                }
            }
        }
    }

    public int[] getIndex() {
        return index;
    }

    public static void main(String[] args) {
        int[] nums_1 = {2, 11, 7, 15};
        int[] nums_2 = {2, 2, 5, 6};
        int target_1 = 9;
        int target_2 = 8;
        LeetCode1_4 myTest_1 = new LeetCode1_4(nums_1, target_1);
        myTest_1.twoSum(myTest_1.start, myTest_1.end);
        System.out.println(Arrays.toString(myTest_1.getIndex()));

        LeetCode1_4 myTest_2 = new LeetCode1_4(nums_2, target_2);
        myTest_2.twoSum(myTest_2.start, myTest_2.end);
        System.out.println(Arrays.toString(myTest_2.getIndex()));

    }


}
