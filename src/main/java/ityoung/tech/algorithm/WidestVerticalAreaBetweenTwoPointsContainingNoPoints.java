package ityoung.tech.algorithm;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        int max = 0;
        Arrays.sort(x);
        for (int i = 0; i < x.length - 1; i++) {
            int cur = x[i + 1] - x[i];
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
