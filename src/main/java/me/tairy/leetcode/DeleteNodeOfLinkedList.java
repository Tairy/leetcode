package me.tairy.leetcode;

import me.tairy.leetcode.util.ListNode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 18:13
 */
public class DeleteNodeOfLinkedList {

    private ListNode head;

    private DeleteNodeOfLinkedList() {
        int[] nums = {1, 2, 3, 4, 5};
        head = ListNode.arrayToListNode(nums);
    }

    private void deleteNode(ListNode node) {
        ListNode prev = head;
        ListNode item = head.next;

        while (null != item) {
            if (item.val == node.val) {
                prev.next = item.next;
                item = null;
                break;
            }
            prev = prev.next;
            item = item.next;
        }
    }

    private void printList() {
        ListNode node = this.head;

        while (null != node) {
            System.out.printf("%d\t", node.val);

            node = node.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeOfLinkedList deleteNodeOfLinkedList = new DeleteNodeOfLinkedList();
        deleteNodeOfLinkedList.deleteNode(new ListNode(3));
        deleteNodeOfLinkedList.printList();

    }
}
