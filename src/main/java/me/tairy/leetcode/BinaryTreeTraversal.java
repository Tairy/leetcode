package me.tairy.leetcode;

import me.tairy.leetcode.util.BinaryTree;
import me.tairy.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-06 09:46
 * <p>
 * 深度遍历的运行过程是先进后出的，方法是栈和递归
 * 广度遍历的运行过程是先进先出的，方法是队列
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
     * 深度优先先序遍历
     *
     * @param parent 父节点
     */
    private static void prevOrderTraversalWithStack(TreeNode parent) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = parent;
        while (node != null || !stack.isEmpty()) {
            if (null != node) {
                stack.push(node);
                System.out.printf("%d\t", node.getVal());
                node = node.getLeft();
            } else {
                TreeNode pNode = stack.pop();
                node = pNode.getRight();
            }
        }
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

    /**
     * 深度优先中序遍历
     *
     * @param parent 父节点
     */
    private static void midOrderTraversalWithStack(TreeNode parent) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = parent;

        while (null != node || !stack.isEmpty()) {
            if (null != node) {
                stack.push(node);
                node = node.getLeft();
            } else {
                TreeNode pNode = stack.poll();
                System.out.printf("%d\t", pNode.getVal());
                node = pNode.getRight();
            }
        }
    }

    /**
     * 递归后序遍历
     *
     * @param parent 父节点
     */
    private static void postOrderTraversal(TreeNode parent) {
        if (null == parent) {
            return;
        }

        postOrderTraversal(parent.getLeft());
        postOrderTraversal(parent.getRight());
        System.out.printf("%d\t", parent.getVal());
    }

    /**
     * 深度优先后序遍历
     * <p>
     * left -> right -> parent
     *
     * @param parent 父节点
     */
    private static void postOrderTraversalWithStack(TreeNode parent) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = parent;
        TreeNode prev = null;

        while (null != node || !stack.isEmpty()) {
            if (null != node) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                if (null == node.getRight() || node.getRight() == prev) {
                    System.out.printf("%d\t", node.getVal());
                    prev = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.getRight();
                }
            }
        }
    }

    /**
     * 层级遍历
     *
     * @param parent 父节点
     */
    private static void levelOrderWithQueue(TreeNode parent) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.push(parent);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (null == node) {
                    continue;
                }

                System.out.printf("%d\t", node.getVal());

                if (null != node.getLeft()) {
                    deque.offer(node.getLeft());
                }

                if (null != node.getRight()) {
                    deque.offer(node.getRight());
                }
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {1, 2, 3, 4, 5, 6};
        binaryTree.init(nums);
        prevOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");
        prevOrderTraversalWithStack(binaryTree.getRoot());
        System.out.print("\n");

        midOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");
        midOrderTraversalWithStack(binaryTree.getRoot());
        System.out.print("\n");

        postOrderTraversal(binaryTree.getRoot());
        System.out.print("\n");
        postOrderTraversalWithStack(binaryTree.getRoot());
        System.out.print("\n");

        levelOrderWithQueue(binaryTree.getRoot());
        System.out.print("\n");
    }
}
