package me.tairy.leetcode;

import me.tairy.leetcode.util.ListNode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 16:28
 * @link https://leetcode-cn.com/problems/linked-list-cycle/
 * 参考鬼吹灯鬼打墙逻辑
 */
public class LinkedListHasCycle {

    private boolean hasCycle(ListNode head) {

        if (null == head) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (null != fast) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;

            if (null != fast) {
                fast = fast.next;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListHasCycle linkedHasCycle = new LinkedListHasCycle();
        int[] nums = {3, 2, 0, -4};
        int pos = 1;

//        int[] nums = {1, 2};
//        int pos = 0;


        ListNode head = ListNode.arrayToListNode(nums);
        ListNode node = head;
        ListNode tail = null;

        while (null != node) {
            if (null == node.next) {
                tail = node;
                break;
            }
            node = node.next;
        }

        int index = 0;
        node = head;
        while (null != node) {
            if (index == pos) {
                tail.next = node;
                break;
            }

            index++;
            node = node.next;
        }

        System.out.printf("%b\n", linkedHasCycle.hasCycle(head));
    }
}
