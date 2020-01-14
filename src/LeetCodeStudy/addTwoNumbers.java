package LeetCodeStudy;


import java.util.Stack;

/**
 * @Author TomAndersen
 * @Date 2019/12/17
 * @Version
 * @Description
 */

public class addTwoNumbers {


    private static ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode emptyHead = new ListNode(-1);
        ListNode temp = emptyHead;
        int sign = 0, sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum %= 10;
            } else {
                sign = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum %= 10;
            } else {
                sign = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum %= 10;
            } else {
                sign = 0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l2 = l2.next;
        }
        if (sign != 0) {
            temp.next = new ListNode(sign);
            temp = temp.next;
        }
        return emptyHead.next;
    }

    private static ListNode _addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cursor = head;
        int sum = 0, sign = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += sign;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            sign = sum / 10;
            sum = 0;
        }
        if (sign != 0) cursor.next = new ListNode(sign);
        return head.next;
    }

    private static ListNode convertToList(int[] nums) throws Exception {
        ListNode head = new ListNode(-1);
        if (nums.length == 0) {
            throw new Exception("数组为空！");
        }
        ListNode sign = head;
        for (int num : nums) {
            ListNode listNode = new ListNode(num);
            sign.next = listNode;
            sign = listNode;
        }
        sign = head.next;
        head.next = null;
        return sign;
    }

    public static void main(String[] args) throws Exception {
        ListNode l1 = convertToList(new int[]{2, 4, 3});
        ListNode l2 = convertToList(new int[]{5, 6, 4});
        System.out.println(_addTwoNumbers(l1, l2).val);
        System.out.println(_addTwoNumbers(l1, l2).next.val);
        System.out.println(_addTwoNumbers(l1, l2).next.next.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

