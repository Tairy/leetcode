package me.tairy.leetcode;

import me.tairy.leetcode.util.ListNode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 17:42
 * @link https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class KthToLastOfLinkedList {

    // 1 ms
    private int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        while (null != fast) {
            if (index == k) {
                slow = slow.next;
            } else {
                index++;
            }
            fast = fast.next;
        }
        return slow.val;
    }

    // 0 ms
    private int kthToLastFast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }


    public static void main(String[] args) {
        KthToLastOfLinkedList kthToLastOfLinkedList = new KthToLastOfLinkedList();
        int k = 2;
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.arrayToListNode(nums);
        System.out.printf("result: %d\n", kthToLastOfLinkedList.kthToLast(head, k));
        System.out.printf("result: %d\n", kthToLastOfLinkedList.kthToLastFast(head, k));
    }
}
