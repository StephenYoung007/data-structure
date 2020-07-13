package ityoung.tech.tree.binarysorttree;

import ityoung.tech.util.ArrayUtil;
import lombok.Data;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] randomArr = ArrayUtil.getRandomArr(10);
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : randomArr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.infixOrder();
    }

}

@Data
class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    public Node search(int value) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.searchParent(value);
        }
    }


}

@Data
class Node{
    private Integer value;
    private Node left;
    private Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(Integer value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        if (value < this.value && this.left != null) {
            this.left.search(value);
        }
        if (value > this.value && this.right != null) {
            this.right.search(value);
        }
        return null;
    }

    public Node searchParent(int value) {
        if (this.value == value) {
            return null;
        }
        if (value < this.value && this.left != null) {
            if (this.left.value == value) {
                return this;
            } else {
                return this.left.searchParent(value);
            }
        } else if (value >= this.value && this.right != null) {
            if (this.right.value == value) {
                return this;
            } else {
                return this.right.searchParent(value);
            }
        } else {
            return null;
        }
    }
}
