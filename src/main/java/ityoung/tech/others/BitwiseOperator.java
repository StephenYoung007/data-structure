package ityoung.tech.others;

import java.util.Arrays;

public class BitwiseOperator {

    public static void main(String[] args) {
        System.out.println(1 << 35);
        System.out.println("\u2122");
        String str = "Hello";
        int[] codePoints = str.codePoints().toArray();
        System.out.println(Arrays.toString(codePoints));
    }
}
