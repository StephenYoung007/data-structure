package ityoung.tech.algorithm;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int currentPosition = 0;
        int step = 0;
        b:
        while (true) {
            int max = 0;
            int nextIndex = 0;
            /**
             * 从当前点开始，遍历所有能到达的点
             */
            for (int j = nums[currentPosition]; j > 0; j--) {
                /**
                 * 从当前点可以直接到达终点，结束循环，步数 +1
                 */
                if ((currentPosition + j) >= nums.length - 1) {
                    step++;
                    break b;
                }
                /**
                 * 判断下一步能覆盖最远的点
                 */
                int index = currentPosition + j + nums[currentPosition + j];
                if (index > max) {
                    max = index;
                    nextIndex = currentPosition + j;
                }
            }
            currentPosition = nextIndex;
            step++;
        }
        return step;
    }

}
