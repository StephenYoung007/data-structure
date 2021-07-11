package ityoung.tech.OjIo;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int v = scanner.nextInt();
        result(a,b,v);
    }

    private static void result(String a, String b, int v) {
        int len = a.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; ++j) {
                int sum = 0;
                for (int k = i; k < i+j;++ k) {
                    sum = Math.abs(a.charAt(k) - b.charAt(k));
                }
                if (sum <= v) {
                    res = Math.max(res,j);
                }
            }
        }
        System.out.println(res);
    }

}
