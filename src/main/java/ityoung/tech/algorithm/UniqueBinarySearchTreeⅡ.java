package ityoung.tech.algorithm;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeⅡ {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new ArrayList<>();
        if (n == 1) {
            TreeNode treeNode = new TreeNode(1);
            trees.add(treeNode);
        }
        return trees;
    }
}
