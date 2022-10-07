package me.tairy.leetcode2.binary.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTree {

    private TreeNode root = null;

    private int size = 0;

    public void init0(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        for (int num : nums) {
            this.root = insert(this.root, num);
        }
    }

    public TreeNode insert(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            root = new TreeNode(val);
            size++;
            return root;
        }

        Queue<TreeNode> scanQueue = new LinkedList<>();
        scanQueue.offer(root);
        while (!scanQueue.isEmpty()) {
            int len = scanQueue.size();

            while (len > 0) {
                TreeNode tmpNode = scanQueue.poll();
                if (Objects.isNull(tmpNode.getLeft())) {
                    tmpNode.setLeft(new TreeNode(val));
                    size++;
                    return root;
                } else {
                    scanQueue.offer(tmpNode.getLeft());
                }

                if (Objects.isNull(tmpNode.getRight())) {
                    tmpNode.setRight(new TreeNode(val));
                    size++;
                    return root;
                } else {
                    scanQueue.offer(tmpNode.getRight());
                }
                len--;
            }
        }

        return root;
    }

    public void insertLeft(TreeNode treeNode, int val) {
        if (Objects.isNull(treeNode.getLeft())) {
            treeNode.setLeft(new TreeNode(val));
            size++;
            return;
        }
        insertLeft(treeNode.getLeft(), val);
    }

    public void insertRight(TreeNode treeNode, int val) {
        if (Objects.isNull(treeNode.getRight())) {
            treeNode.setRight(new TreeNode(val));
            size++;
            return;
        }
        insertRight(treeNode.getRight(), val);
    }

    public void print() {

    }
}
