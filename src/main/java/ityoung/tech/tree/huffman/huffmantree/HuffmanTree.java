package ityoung.tech.tree.huffman.huffmantree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {
//        int[] arr = ArrayUtil.getRandomArr(10);
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        Node huffmanTree = getHuffmanTree(nodes);
        huffmanTree.preOrder();
    }

    public static Node getHuffmanTree(List<Node> nodes) {
        Node node = null;
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            node = new Node(nodes.get(0).getValue() + nodes.get(1).getValue());
            node.setLeft(nodes.get(0));
            node.setRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
        }
        return node;
    }
}

@Data
class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
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


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}