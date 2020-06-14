package ityoung.tech.binaryTree;


import lombok.Data;


public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "黄忠");
        HeroNode node2 = new HeroNode(2, "赵云");
        HeroNode node3 = new HeroNode(3, "马超");
        HeroNode node4 = new HeroNode(4, "关羽");
        HeroNode node5 = new HeroNode(5, "张飞");
        HeroNode node6 = new HeroNode(6, "刘备");
        tree.setRoot(node1);
        node1.setLeft(node2);
        node2.setRight(node3);
        node1.setRight(node4);
        node4.setRight(node5);
        node2.setLeft(node6);
        tree.preOrder();
        System.out.println("======================");
        tree.infixOrder();
        System.out.println("======================");
        tree.postOrder();
        System.out.println("======================");
        HeroNode orderSearch = tree.preOrderSearch(5);
        System.out.println(orderSearch);
        boolean delete = tree.delete(6);
        String msg = delete == true ? "节点删除成功" : "节点删除失败，查无此节点";
        System.out.println(msg);
    }
}

@Data
class BinaryTree {
    private HeroNode root;

    public void preOrder() {
        if (this.root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return root.preOrderSearch(no);
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return root.postOrderSearch(no);
        }
        return null;
    }

    public boolean delete(int no) {
        boolean flag = false;
        if (this.root != null) {
            if (this.root.getId() == no) {
                this.root = null;
                flag = true;
            } else {
                flag = this.root.delete(no);
            }
        }

        return flag;
    }



}

@Data
class HeroNode {
    private Integer id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
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

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        System.out.println(this);
        HeroNode node = null;
        if (this.id == no) {
            return this;
        }
        if (this.left != null) {
            node = this.left.preOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        return node;
    }

    public HeroNode infixOrderSearch(int no) {
        System.out.println(this);
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.infixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.id == no) {
            return this;
        }
        if (this.right != null) {
            node = this.right.infixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        return node;
    }


    public HeroNode postOrderSearch(int no) {
        System.out.println(this);
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.postOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.id == no) {
            return this;
        }
        if (this.right != null) {
            node = this.right.postOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        return node;
    }

    public boolean delete(int no) {
        boolean flag = false;
        if (this.left != null) {
            if (this.left.getId() == no) {
                this.left = null;
                flag = true;
            } else {
                flag = this.left.delete(no);
            }
        }
        if (flag == true) {
            return flag;
        }
        if (this.right != null) {
            if (this.right.getId() == no) {
                this.right = null;
                flag = true;
            } else {
                flag = this.right.delete(no);
            }
        }

        return flag;
    }
}
