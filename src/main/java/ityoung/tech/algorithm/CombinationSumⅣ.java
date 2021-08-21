package ityoung.tech.algorithm;

import java.util.Arrays;

public class CombinationSumⅣ {
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int max = Math.max(nums[nums.length - 1], target);
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int i = 1; i <= max; i++) {
            int min = Math.min(nums.length, i);
            for (int j = 0; j < min; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 5};
        int combinationSum4 = combinationSum4(nums, 6);
        System.out.println(combinationSum4);
    }
}
