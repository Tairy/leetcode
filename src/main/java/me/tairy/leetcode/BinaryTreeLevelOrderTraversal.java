package me.tairy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-06 09:09
 */
public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ret = new ArrayList<>();

        if (null == root) {
            return ret;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (null == head) {
                    continue;
                }
                list.add(head.val);

                if (null != head.left) {
                    queue.offer(head.left);
                }

                if (null != head.right) {
                    queue.offer(head.right);
                }
            }

            ret.add(list);
        }

        return ret;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

        int[] arr = {1, 2, 3, 4, 5, 6};

        List<List<Integer>> ret = binaryTreeLevelOrderTraversal.levelOrder(null);
        System.out.println(ret.toString());
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
