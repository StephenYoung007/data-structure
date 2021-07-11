package ityoung.tech.algorithm;


import java.util.*;

public class HouseRobber2 {

    private static Map<TreeNode, Integer> container = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (container.get(root) != null) {
            return container.get(root);
        }

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val = val + (rob(root.right.left) + rob(root.right.right));
        }

        int max = Math.max(val + root.val, rob(root.left) + rob(root.right));
        container.put(root, max);
        return max;
    }
}
