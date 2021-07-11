package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int dp_1 = nums[0];
        int dp_2 = 0;
        int max = dp_1;
        for (int i = 1; i < nums.length; i++) {
            if (dp_1 > 0) {
                dp_2 = dp_1 + nums[i];
            } else {
                dp_2 = nums[i];
            }
            dp_1 = dp_2;
            max = Math.max(max, dp_2);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        log.info(maxSubArray + "");
    }
}
