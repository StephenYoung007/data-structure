package ityoung.tech.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class ValidateBinarySearchTree {
    private AtomicInteger last = null;
    private boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        preOrder(root);
        return flag;
    }

    private void preOrder(TreeNode root) {
        if (root.left != null) {
            preOrder(root.left);
        }
        if (last == null) {
            last = new AtomicInteger(root.val);
        } else {
            if (last.get() >= root.val) {
                flag = false;
                return;
            } else {
                last.set(root.val);
            }
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
}
