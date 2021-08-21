package ityoung.tech.algorithm;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            List<Integer> currentLevelValue = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = currentLevel.poll();
                currentLevelValue.add(poll.val);
                if (poll.left != null) {
                    currentLevel.offer(poll.left);
                }
                if (poll.right != null) {
                    currentLevel.offer(poll.right);
                }
            }
            results.add(currentLevelValue);
        }
        Collections.reverse(results);
        return results;
    }
}
