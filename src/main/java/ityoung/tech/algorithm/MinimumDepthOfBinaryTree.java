package ityoung.tech.algorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedBlockingQueue<>();
        currentLevel.add(root);
        int depth = 1;
        while (currentLevel.size() != 0) {
            int size = currentLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = currentLevel.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    currentLevel.offer(node.left);
                }
                if (node.right != null) {
                    currentLevel.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
