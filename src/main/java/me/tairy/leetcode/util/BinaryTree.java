package me.tairy.leetcode.util;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/24 上午9:56
 */
public class BinaryTree {

    /**
     * root
     */
    private TreeNode root = null;

    /**
     * 长度
     */
    private int size = 0;

    public TreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    /**
     * 初始化函数
     *
     * @param nums 数组序列
     */
    public void init(int[] nums) {
        root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                insertLeft(root, nums[i]);
            } else {
                insertRight(root, nums[i]);
            }
        }
    }

    /**
     * 左子树递归插入
     *
     * @param parent 父节点
     * @param val    值
     */
    private void insertLeft(TreeNode parent, int val) {
        if (null == parent.left) {
            parent.left = new TreeNode(val);
            size++;
            return;
        }

        insertLeft(parent.left, val);
    }

    /**
     * 右子树递归插入
     *
     * @param parent 父节点
     * @param val    值
     */
    private void insertRight(TreeNode parent, int val) {
        if (null == parent.right) {
            parent.right = new TreeNode(val);
            size++;
            return;
        }
        insertRight(parent.right, val);
    }

    private boolean isEnd(TreeNode node) {
        return null == node;
    }

    private boolean isLeaf(TreeNode node) {
        return null == node.left && null == node.right;
    }

//    private void prevOrderIterator(TreeNode parent) {
//        if (null != parent) {
//            System.out.printf("%d\t", parent.val);
//            prevOrderIterator(parent.left);
//            prevOrderIterator(parent.right);
//        }
//    }
//
//    private void prevOrderIteratorWithStack(TreeNode parent) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode pNode = parent;
//
//        while (pNode != null || !stack.isEmpty()) {
//            if (pNode != null) {
//                System.out.printf("%d\t", pNode.val);
//                stack.push(pNode);
//                pNode = pNode.left;
//            } else {
//                TreeNode node = stack.pop();
//                pNode = node.right;
//            }
//        }
//    }
//
//    private void midOrderIterator(TreeNode parent) {
//        if (null != parent) {
//            midOrderIterator(parent.left);
//            System.out.printf("%d\t", parent.val);
//            midOrderIterator(parent.right);
//        }
//    }
//
//    private void midOrderIteratorWithStack(TreeNode parent) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode pNode = parent;
//
//        while (null != pNode || !stack.isEmpty()) {
//            if (null != pNode) {
//                stack.push(pNode);
//                pNode = pNode.left;
//            } else {
//                TreeNode node = stack.pop();
//                System.out.printf("%d\t", node.val);
//                pNode = node.right;
//            }
//        }
//    }
//
//    private void postOrderIterator(TreeNode parent) {
//        if (null != parent) {
//            postOrderIterator(parent.left);
//            postOrderIterator(parent.right);
//            System.out.printf("%d\t", parent.val);
//        }
//    }
//
//    private void postOrderIteratorWithStack(TreeNode parent) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode pNode = parent;
//        TreeNode prev = null;
//
//        while (null != pNode || !stack.isEmpty()) {
//            if (null != pNode) {
//                stack.push(pNode);
//                pNode = pNode.left;
//            } else {
//                pNode = stack.pop();
//                if (null == pNode.right || pNode.right == prev) {
//                    System.out.printf("%d\t", pNode.val);
//                    prev = pNode;
//                    pNode = null;
//                } else {
//                    stack.push(pNode);
//                    pNode = pNode.right;
//                }
//            }
//        }
//    }

//    private void printTree() {
//        System.out.println("====== start to print tree ======");
//        System.out.printf("size: %d\nprev_iterator:\n", size);
//        this.prevOrderIterator(root);
//        System.out.println("\nprev_iterator_with_stack:");
//        this.prevOrderIteratorWithStack(root);
//        System.out.println("\nmid_iterator:");
//        this.midOrderIterator(root);
//        System.out.println("\nmid_iterator_with_stack:");
//        this.midOrderIteratorWithStack(root);
//        System.out.println("\npost_iterator:");
//        this.postOrderIterator(root);
//        System.out.println("\npost_iterator_with_stack:");
//        this.postOrderIteratorWithStack(root);
//    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        binaryTree.init(nums);
//        binaryTree.printTree();
    }
}