package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-08 14:19
 */
public class BinaryTreeMirror {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.getLeft() != null) stack.add(node.getLeft());
            if (node.getRight() != null) stack.add(node.getRight());
            TreeNode tmp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(tmp);
        }
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {1, 2, 3, 4, 5, 6};
        binaryTree.init(nums);
        BinaryTreeMirror binaryTreeMirror = new BinaryTreeMirror();

        TreeNode ret = binaryTreeMirror.mirrorTree(binaryTree.getRoot());

        System.out.println(ret.getVal());
    }
}
