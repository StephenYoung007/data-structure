package ityoung.tech.tree.huffman.huffmancode;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java? fuck you";
        byte[] contentBytes = content.getBytes();
        byte[] zip = huffmanZip(contentBytes);
        log.info(Arrays.toString(zip));
        StringBuilder bitStringBuilder = new StringBuilder();
        int count = 0;
        for (byte b : zip) {
            String bitString;
            if (count < zip.length - 1) {
                bitString = byteToBitString(b, true);
            } else {
                bitString = byteToBitString(b, false);
            }
            bitStringBuilder.append(bitString);
            count++;
        }
        log.info(bitStringBuilder.toString());
        String s = fromBitStringToContent(bitStringBuilder.toString());
        log.info(s);
    }

    public static String fromBitStringToContent(String bitString) {
        Map<String, Byte> huffmanUnzipMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            huffmanUnzipMap.put(entry.getValue(), entry.getKey());
        }
        StringBuilder origin = new StringBuilder();
        int codeLength = 0;
        for (int i = 0; i < bitString.length(); i += codeLength) {
            codeLength = 1;
            while (huffmanUnzipMap.get(bitString.substring(i, i + codeLength)) == null) {
                codeLength++;
            }
            origin.append((char)(int)huffmanUnzipMap.get(bitString.substring(i, i + codeLength)));
        }
        return origin.toString();
    }

    public static String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if (flag) {
            return binaryString.substring(binaryString.length() - 8);
        }
        return binaryString;
    }

    public static byte[] huffmanZip(byte[] contentBytes) {
        List<Node> nodes = getNodes(contentBytes);
        Collections.sort(nodes);
        Node huffmanTree = createHuffmanTree(nodes);
//        huffmanTree.preOrder();
        getCodesMap(huffmanTree, "", stringBuilder);
        byte[] zip = zip(contentBytes, huffmanCodeMap);
        return zip;
    }

    public static byte[] zip(byte[] bytes, Map huffmanCodeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte contentByte : bytes) {
            stringBuilder.append(huffmanCodeMap.get(contentByte));
        }
        log.info(stringBuilder.toString());
        int length;
        if (stringBuilder.length() % 8 == 0) {
            length = stringBuilder.length() / 8;
        } else {
            length = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[length];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            } else {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            }
            index++;
        }
        return huffmanCodeBytes;
    }

    static Map<Byte, String> huffmanCodeMap = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    public static void getCodesMap(Node node, String code, StringBuilder stringBuilder) {
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
