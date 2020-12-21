package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-21 09:49
 * @link https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTowNumbers {

    private static ListNode addTowNumbers(ListNode head1, ListNode head2) {
        ListNode node = null;
        ListNode head = null;
        int append = 0;

        do {
            int val = 0;
            if (null == head1) {
                val = head2.val;
                head2 = head2.next;
            } else if (null == head2) {
                val = head1.val;
                head1 = head1.next;
            } else {
                val = head1.val + head2.val;
                head1 = head1.next;
                head2 = head2.next;
            }

            val += append;
            append = val >= 10 ? 1 : 0;

            if (null == node) {
                node = new ListNode(val % 10);
                head = node;
            } else {
                node.next = new ListNode(val % 10);
                node = node.next;
            }

        } while (null != head1 || null != head2);

        if (append == 1) {
            node.next = new ListNode(append);
        }

        return head;
    }

    public static void main(String[] args) {
        int[] num1 = {9, 9, 9, 9, 9, 9, 9};
        int[] num2 = {9, 9, 9};

        ListNode head1 = intArrToListNode(num1);
        ListNode head2 = intArrToListNode(num2);
        ListNode result = addTowNumbers(head1, head2);

        do {
            System.out.println(result.val);
            result = result.next;
        } while (null != result);
    }

    private static ListNode intArrToListNode(int[] num) {
        ListNode head = null;

        for (int value : num) {
            if (null == head) {
                head = new ListNode(value);
            } else {
                head = new ListNode(value, head);
            }
        }

        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
