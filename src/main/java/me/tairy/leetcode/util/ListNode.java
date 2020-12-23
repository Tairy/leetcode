package me.tairy.leetcode.util;

/**
 * package: me.tairy.leetcode.util
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 17:44
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode arrayToListNode(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        ListNode node = null;

        for (int num : nums) {
            node = new ListNode(num);
            if (null == head) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }
}