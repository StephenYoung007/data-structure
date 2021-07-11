package ityoung.tech.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LongestIncreasingSubsequence2 {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + right / 2;
                if (nums[i] > top[mid]) {
                    left = mid + 1;
                } else if (nums[i] < top[mid]) {
                    right = mid;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = nums[i];
        }
        return piles;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }
}