package LeetCodeStudy;

import java.util.*;

/**
 * @Author TomAndersen
 * @Date 2019/12/25
 * @Version
 * @Description 用于测试各种数据结构
 */

public class HelloWorld {
    public static void main(String[] args) {
        final String SEPERATOR = "-----------------------------";
        String name = new String("TomAndersen");
        StringBuilder myName = new StringBuilder(name);
        char[] chars = name.toCharArray();

        System.out.println(myName.charAt(1));// charAt也是随机访问char数组，速度很快
        System.out.println(name.charAt(1));
        System.out.println(myName.substring(1, 2));


        int x = 1;
        x = x++;
        System.out.println(x);
        System.out.println(x & 1);
        System.out.println(x / 2);

        System.out.println(x > 1 ? 1 : 2);


        System.out.println(SEPERATOR);
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(LeetCode4.findMedianSortedArrays(nums1, nums2));

        System.out.println(SEPERATOR);
        int x1 = 1;
        // 都可以将对应参数转换成字符串类型
        System.out.println(Integer.toString(x1));
        System.out.println(String.valueOf(x1));
        String num1 = "-032";
        String num2 = "+032";
        System.out.println(Integer.valueOf(num1));
        System.out.println(Integer.valueOf(num2));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(SEPERATOR);
        int y = 0x80000001;
        System.out.println(Integer.toHexString(y));

        int[] nums = new int[3];
        System.out.println(nums[0]);
        System.out.println(name == "TomAndersen");

        String a = "TomAndersen";
        String b = new String("TomAndersen");
        System.out.println(a == b);

        String classFile = "co1m.jd.". replaceAll("\\d", "/") + "MyClass.class";
        System.out.println(classFile);

        int m= 112;
        System.out.println(Integer.toHexString(m));

    }
}
