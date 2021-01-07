package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.HashMap;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-06 09:46
 */
public class BinaryTreeTraversal {


    /**
     * 递归先序遍历
     *
     * @param parent 根
     */
    private static void prevOrderTraversal(TreeNode parent) {
        if (null == parent) {
            return;
        }
        System.out.printf("%d\t", parent.getVal());
        prevOrderTraversal(parent.getLeft());
        prevOrderTraversal(parent.getRight());
    }

    /**
     * 递归中序遍历
     *
     * @param parent 父节点
     */

    private static void midOrderTraversal(TreeNode parent) {
        if (null == parent) {
            return;
        }

        midOrderTraversal(parent.getLeft());
        System.out.printf("%d\t", parent.getVal());
        midOrderTraversal(parent.getRight());
    }

    private static void postOrderTraversal(TreeNode parent) {
        if (null == parent) {
            return;
        }

        postOrderTraversal(parent.getLeft());
        postOrderTraversal(parent.getRight());
        System.out.printf("%d\t", parent.getVal());
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {1, 2, 3, 4, 5, 6};
        binaryTree.init(nums);
        prevOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");
        midOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");
        postOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");

//        HashMap
    }
}
