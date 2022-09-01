package ityoung.tech.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int diameter = diameterOfBinaryTree(node1);
        System.out.println(diameter);

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        AtomicInteger max = new AtomicInteger(-1000);
        depthSearch(root, max);
        return max.get();
    }

    private static int getMaxDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            root.val = 0;
            return 0;
        }
        if (root.left != null) {
            root.val = getMaxDepth(root.left) + 1;
        } else {
            root.val = -101;
        }
        if (root.right != null) {
            root.val = Math.max(root.val, getMaxDepth(root.right) + 1);
        }
        return root.val;
    }

    private static void depthSearch(TreeNode root, AtomicInteger max) {
        if (root == null) {
            return;
        }
        int diameter = 0;
        if (root.left != null) {
            diameter += root.left.val + 1;
        }
        if (root.right != null) {
            diameter += root.right.val + 1;
        }
        if (diameter > max.get()) {
            max.set(diameter);
        }
        depthSearch(root.left, max);
        depthSearch(root.right, max);
    }

}