package ityoung.tech.OjIo;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return;
        }
        int userNum = 100;
        lastUserNum(userNum, m);

    }

    private static void lastUserNum(int userNum, int num) {
        boolean[] arr = new boolean[userNum];
        Arrays.fill(arr, true);
        int next = 1;
        int index = 0;
        int count = userNum;
        while (count >= num) {
            if (arr[index] == true) {
                if (next == 3) {
                    arr[index] = false;
                    --count;
                    next = 1;
                } else {
                    ++next;
                }
            }
            ++index;
            if (index == userNum) {
                index = 0;
            }
        }
        StringBuffer buffer = null;
        for (int i = 0; i < userNum; i++) {
            if (arr[i] == true) {
                int n = i + 1;
                if (buffer == null) {
                    buffer = new StringBuffer();
                    buffer.append(n);
                } else {
                    buffer.append("," + n);
                }
            }
        }
        System.out.println(buffer);
    }
}
