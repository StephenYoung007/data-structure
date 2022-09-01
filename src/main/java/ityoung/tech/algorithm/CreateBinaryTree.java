package ityoung.tech.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int num = descriptions.length;
        Map<Integer, TreeNode> treeNodeMap = new HashMap();
        Map<Integer, Integer> parentMap = new HashMap();
        for (int i = 0; i < num; i++) {
            Integer parent = descriptions[i][0];
            Integer child = descriptions[i][1];
            parentMap.put(child, parent);
            int isLeft = descriptions[i][2];
            TreeNode parentNode;
            if (treeNodeMap.get(parent) == null) {
                parentNode = new TreeNode();
                parentNode.val = parent;
                treeNodeMap.put(parent, parentNode);
            } else {
                parentNode = treeNodeMap.get(parent);
            }
            TreeNode childNode;
            if (treeNodeMap.get(child) == null) {
                childNode = new TreeNode();
                childNode.val = child;
                treeNodeMap.put(child, childNode);
            } else {
                childNode = treeNodeMap.get(child);
            }
            if (isLeft == 0) {
                parentNode.right = childNode;
            } else {
                parentNode.left = childNode;
            }
        }
        int parentValue = descriptions[0][0];
        while (parentMap.get(parentValue) != null) {
            parentValue = parentMap.get(parentValue);
        }
        return treeNodeMap.get(parentValue);
    }
}