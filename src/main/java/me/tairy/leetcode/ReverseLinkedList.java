package me.tairy.leetcode;

import me.tairy.leetcode.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-21 21:10
 * @link https://leetcode-cn.com/problems/reverse-linked-list/s
 */
public class ReverseLinkedList {

    private static ListNode reverseWithStack(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        while (null != node) {
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        ListNode newHead = stack.pop();
        ListNode tail = newHead;
        for (int i = 1; i < size; i++) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return newHead;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while (null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.arrayToListNode(nums);
        ListNode ret = reverse(head);
    }
}
