package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-13 16:53
 */
public class BinaryTreeSumPath {

    private static boolean findPathSum(int sum, TreeNode root) {
        if (null == root) {
            return false;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<Integer> path = new LinkedList<>();

        TreeNode node = root;
        Integer val = root.getVal();
        stack.push(root);
        path.push(root.getVal());

        while (!stack.isEmpty()) {
            node = stack.pop();
            val = path.pop();

            if (null == node.getLeft() && null == node.getRight() && sum == val) {
                return true;
            }

            if (null != node.getLeft()) {
                stack.push(node.getLeft());
                path.push(val + node.getLeft().getVal());
            }

            if (null != node.getRight()) {
                stack.push(node.getRight());
                path.push(val + node.getRight().getVal());
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int num = 6;
        int[] nums = {1, 2, 3, 4, 5};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(nums);
        System.out.println(findPathSum(12, binaryTree.getRoot()));
    }
}
