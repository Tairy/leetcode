package me.tairy.leetcode2.binary.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private TreeNode left;

    private TreeNode right;

    private int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
