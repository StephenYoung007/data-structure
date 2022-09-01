package ityoung.tech.algorithm;

public class SufficientSubset {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (maxSum(root) < limit) {
            return null;
        }
        checkRoot(root, 0, limit);
        return root;
    }

    private void checkRoot(TreeNode root, int basic, int limit) {
        if (root != null) {
            basic += root.val;
            if (root.left != null && (maxSum(root.left) + basic) < limit) {
                root.left = null;
            } else {
                checkRoot(root.left, basic, limit);
            }
            if (root.right != null && (maxSum(root.right) + basic) < limit) {
                root.right = null;
            } else {
                checkRoot(root.right, basic, limit);
            }
        }
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return root.val + maxSum(root.right);
        }
        if (root.right == null && root.left != null) {
            return root.val + maxSum(root.left);
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = maxSum(root.left);
        }
        if (root.right != null) {
            right = maxSum(root.right);
        }
        return Math.max(left, right) + root.val;
    }
}
