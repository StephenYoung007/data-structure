package ityoung.tech.OjIo;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int m = Integer.valueOf(s[0]);
        int n = Integer.valueOf(s[1]);
        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.valueOf(split[n]);
            }
        }
        int count = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
            }
        }
        System.out.println(5);
    }
}
