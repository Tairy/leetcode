package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

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
                list.add(head.getVal());

                if (null != head.getLeft()) {
                    queue.offer(head.getLeft());
                }

                if (null != head.getRight()) {
                    queue.offer(head.getRight());
                }
            }

            ret.add(list);
        }

        return ret;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

        int[] arr = {1, 2, 3, 4, 5, 6};

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(arr);

        List<List<Integer>> ret = binaryTreeLevelOrderTraversal.levelOrder(binaryTree.getRoot());
        System.out.println(ret.toString());
    }
}
