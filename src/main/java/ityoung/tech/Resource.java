package ityoung.tech;

import java.util.Arrays;

public class Resource {
    public static void main(String[] args) {
        int n = 666;
        /**
         * 代表所有n个人可以选择ABC的资源消耗
         */
        int[][] res = new int[n][3];
        int[][] dp = new int[n][3];
        /**
         * 第一个人选A
         */
        dp[0][0] = res[0][0];
        /**
         * 第一个人选B
         */
        dp[0][1] = res[0][1];
        /**
         * 第一个人选C
         */
        dp[0][2] = res[0][2];
        for (int i = 1; i < n; i++) {
            /**
             * 第i个人选A，需要保证前面一个人选B或者C,下同
             */
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + res[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + res[i][0];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + res[i][0];
        }
        Arrays.sort(dp[n - 1]);
        System.out.println(dp[n - 1][0]);
    }
}
