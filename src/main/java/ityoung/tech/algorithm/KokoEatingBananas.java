package ityoung.tech.algorithm;

import java.util.Arrays;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int length = piles.length;
        int init = (piles[0] % h) == 0 ? (piles[0] / h) : (piles[0] / h + 1);
        int speed = init;
        for (int i = init; i <= piles[length - 1]; i++) {
            long duration = 0;
            for (int j = 0; j < length; j++) {
                duration += ((piles[j] % speed) == 0 ? (piles[j] / speed) : (piles[j] / speed + 1));
            }
            if (duration > h) {
                speed = i + 1;
            } else {
                break;
            }
        }
        return speed;
    }

    public static void main(String[] args) {
        int speed = minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);
        System.out.println(speed);
    }
}
