package ityoung.tech.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    private static int eggDrop(int k, int n, int[][] dp) {
        if (dp[k][n] != -1) {
            return dp[k][n];
        }
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE - 10000;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(eggDrop(k - 1, i - 1, dp), eggDrop(k, n - i, dp)) + 1);
        }
        dp[k][n] = res;
        return res;
    }

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return eggDrop(k, n, dp);
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(6, 10000));
    }
}
