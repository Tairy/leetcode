package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-13 18:12
 */
public class BinaryTreePaths {

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<String> paths = new LinkedList<String>();

        stack.push(root);
        paths.push(String.valueOf(root.getVal()));

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            String path = paths.pop();

            if (null == node.getLeft() && null == node.getRight()) {
                ret.add(path);
            }

            if (null != node.getLeft()) {
                stack.push(node.getLeft());
                paths.push(path + "->" + String.valueOf(node.getLeft().getVal()));
            }

            if (null != node.getRight()) {
                stack.push(node.getRight());
                paths.push(path + "->" + String.valueOf(node.getRight().getVal()));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int num = 6;
        int[] nums = {1, 2, 3, 4, 5};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(nums);
        System.out.println(binaryTreePaths(binaryTree.getRoot()));
    }
}
