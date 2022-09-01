package ityoung.tech.algorithm;

public class ReachaNumber {
    public static int reachNumber(int target) {
        int cur = 1;
        int range = 0;
        target = Math.abs(target);
        while (range < target) {
            range += cur;
            cur++;
        }
        if ((target - range) % 2 == 0) {
            return cur - 1;
        }
        if (cur % 2 != 0) {
            return cur;
        } else {
            return cur + 1;
        }
    }
}
