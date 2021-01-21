package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-13 19:09
 */
public class BinaryTreeSumPathAllFromRoot {

    private static List<String> pathSumFromRoot(TreeNode root, int sum) {
        List<String> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sums = new LinkedList<>();
        Deque<String> paths = new LinkedList<>();

        stack.push(root);
        sums.push(root.getVal());
        paths.push(String.valueOf(root.getVal()));

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer val = sums.pop();
            String path = paths.pop();

            if (val == sum) {
                ret.add(path);
            }

            if (null != node.getLeft()) {
                stack.push(node.getLeft());
                sums.push(val + node.getLeft().getVal());
                paths.push(path + "->" + String.valueOf(node.getLeft().getVal()));
            }

            if (null != node.getRight()) {
                stack.push(node.getRight());
                sums.push(val + node.getRight().getVal());
                paths.push(path + "->" + String.valueOf(node.getRight().getVal()));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(nums);
        System.out.println(pathSumFromRoot(binaryTree.getRoot(), 7));
    }
}
