package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        return getDP(word1, word2, word1.length(), word2.length(), dp);
    }

    private static int getDP(String word1, String word2, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return getDP(word1, word2, i - 1, j - 1, dp);
        }
        int min = min(getDP(word1, word2, i - 1, j, dp) + 1, getDP(word1, word2, i, j - 1, dp) + 1, getDP(word1, word2, i - 1, j - 1, dp) + 1);
        dp[i][j] = min;
        return min;
    }

    private static int min(int a, int b, int c) {
        int min = (a < b) ? a : b;
        min = (min < c) ? min : c;
        return min;
    }

    public static void main(String[] args) {
        int minDistance = minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");
//        int minDistance = minDistance("nylhydrazine", "enylhydrazone");
//        int minDistance = minDistance("intentio", "intention");
        System.out.println(minDistance);
    }
}
