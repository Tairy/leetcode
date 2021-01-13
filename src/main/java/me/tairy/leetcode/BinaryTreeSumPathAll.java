package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-13 18:59
 */
public class BinaryTreeSumPathAll {

    private static int pathSum(TreeNode root, int sum) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.init(nums);
        pathSum(binaryTree.getRoot(), 6);
    }
}
