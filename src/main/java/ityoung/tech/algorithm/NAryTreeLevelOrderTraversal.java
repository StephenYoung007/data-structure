package ityoung.tech.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                currentLevel.add(poll.val);
                if (poll.children != null && poll.children.size() > 0) {
                    List<Node> sub = poll.children;
                    for (int j = 0; j < sub.size(); j++) {
                        queue.offer(sub.get(j));
                    }
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
