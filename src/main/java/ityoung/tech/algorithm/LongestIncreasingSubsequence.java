package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] increasingLength = new int[nums.length];
        increasingLength[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && increasingLength[j] + 1 > max) {
                    max = increasingLength[j] + 1;
                }
            }
            increasingLength[i] = max;
        }
        int max = 1;
        for (int i = 0; i < increasingLength.length; i++) {
            max = Math.max(max, increasingLength[i]);
        }
        return max;
    }
}
