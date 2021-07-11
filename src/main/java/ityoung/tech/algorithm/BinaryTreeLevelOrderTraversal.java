package ityoung.tech.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        List<TreeNode> trees = new ArrayList<>();
        trees.add(root);
        addTrees(trees, container);
        return container;
    }

    private void addTrees(List<TreeNode> trees, List<List<Integer>> container) {
        List<TreeNode> subTrees = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i) != null) {
                values.add(trees.get(i).val);
                if (trees.get(i).left != null) {
                    subTrees.add(trees.get(i).left);
                }
                if (trees.get(i).right != null) {
                    subTrees.add(trees.get(i).right);
                }
            }
        }
        if (values.size() != 0) {
            container.add(values);
        }
        if (subTrees.size() != 0) {
            addTrees(subTrees, container);
        }
    }
}
