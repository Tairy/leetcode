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
 * @date 2021-01-13 18:59
 */
public class BinaryTreeSumPathAll {

    private static List<String> pathSumWithStack(TreeNode root, int sum) {
        if (null == root) {
            return null;
        }
        List<String> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (null != node || !stack.isEmpty()) {
            if (null != node) {
                getPathWithStack(node, ret, sum);
                stack.push(node);
                node = node.getLeft();
            } else {
                TreeNode tNode = stack.pop();
                node = tNode.getRight();
            }
        }
        return ret;
    }

    private static List<String> pathSum(TreeNode root, int sum) {
        List<String> ret = new LinkedList<>();
        paths(root, ret, sum);
        return ret;
    }


    private static void paths(TreeNode root, List<String> ret, int sum) {
        if (null == root) {
            return;
        }

        getPathWithStack(root, ret, sum);
        paths(root.getLeft(), ret, sum);
        paths(root.getRight(), ret, sum);
    }

    private static void getPathWithStack(TreeNode root, List<String> ret, int sum) {
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
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(nums);
        List<String> ret = new ArrayList<>();
        System.out.println(pathSumWithStack(binaryTree.getRoot(), 6));
        System.out.println(pathSum(binaryTree.getRoot(), 6));
    }
}
