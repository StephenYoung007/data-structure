package ityoung.tech.OjIo;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(",");
        boolean[][] shareFlag = new boolean[strArr.length][strArr.length];
        int maxNum = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr.length; j++) {
                if (i == j) {
                    break;
                }
                if (!shareTheSame(strArr[i], strArr[j])) {
                    shareFlag[i][j] = false;
                    maxNum = Math.max(maxNum, strArr[i].length()*strArr[j].length());
                }
            }
        }
        System.out.println(maxNum);
    }

    private static boolean shareTheSame(String s, String s1) {
        boolean flag = false;
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (s1.indexOf(c) != -1) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
