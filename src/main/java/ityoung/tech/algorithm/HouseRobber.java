package ityoung.tech.algorithm;

public class HouseRobber {
    public int subRob(int[] nums) {
        int[] total = new int[nums.length];
        total[0] = nums[0];
        if (nums.length > 1) {
            total[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            total[i] = Math.max(total[i - 2] + nums[i], total[i - 1]);
        }
        return total[nums.length - 1];
    }

    public int rob(int[] nums) {
        int[] total1 = new int[nums.length - 1];
        int[] total2 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            total1[i - 1] = nums[i];
            total2[i - 1] = nums[i - 1];
        }
        if (nums.length > 1) {
            return Math.max(subRob(total1), subRob(total2));
        } else {
            return nums[0];
        }
    }
}
