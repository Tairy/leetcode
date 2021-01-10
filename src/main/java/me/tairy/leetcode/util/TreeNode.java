package me.tairy.leetcode.util;

/**
 * package: me.tairy.leetcode.util
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-06 09:45
 */
public class TreeNode {

    TreeNode left;

    TreeNode right;

    int val;

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }

    TreeNode(int val) {
        this.val = val;
    }
}
