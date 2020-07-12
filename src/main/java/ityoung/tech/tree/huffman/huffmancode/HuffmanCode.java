package ityoung.tech.tree.huffman.huffmancode;

import lombok.Data;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        int i = (byte)Integer.parseInt("10101000", 2);
        int j = (byte) 168;
        System.out.println(i);
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        List<Node> nodes = getNodes(contentBytes);
        Collections.sort(nodes);
        Node huffmanTree = createHuffmanTree(nodes);
        huffmanTree.preOrder();
        getCodesMap(huffmanTree, "", stringBuilder);
        System.out.println(huffmanCodeMap);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte contentByte : contentBytes) {
            stringBuilder.append(huffmanCodeMap.get(contentByte));
        }
        System.out.println(stringBuilder.toString().length());

    }

    static Map<Byte, String> huffmanCodeMap = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    public static void getCodesMap(Node node, String code, StringBuilder stringBuilder) {
//        stringBuilder.append(code);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.getData() == null) {
                getCodesMap(node.getLeft(), "0", stringBuilder2);
                getCodesMap(node.getRight(), "1", stringBuilder2);
            } else {
                huffmanCodeMap.put(node.getData(), stringBuilder2.toString());
            }
        }
    }

    public static Node createHuffmanTree(List<Node> nodes) {
        Node node = null;
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            node = new Node(null, nodes.get(0).getWeight() + nodes.get(1).getWeight());
            node.setLeft(nodes.get(0));
            node.setRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
        }
        return node;
    }

    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        Set<Map.Entry<Byte, Integer>> entries = counts.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }
}

@Data
class Node implements Comparable<Node> {
    private Byte data;
    private int weight;
    private Node left;
    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
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
        return this.weight - o.weight;
    }
}
