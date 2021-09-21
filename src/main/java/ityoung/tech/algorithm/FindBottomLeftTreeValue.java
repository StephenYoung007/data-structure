package ityoung.tech.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        boolean flag;
        b:
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                currentLevel.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    flag = true;
                }
                if (poll.right != null) {
                    flag = true;
                    queue.offer(poll.right);
                }
            }
            result = currentLevel;
            if (!flag) {
                break b;
            }
        }
        Integer value = result.get(0);
        return value;
    }
}
