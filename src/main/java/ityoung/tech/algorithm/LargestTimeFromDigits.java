package ityoung.tech.algorithm;

import java.util.Arrays;

public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        if ((10 * arr[0] + arr[1]) > 23) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        if (arr[0] == 2) {
            if ((10 * arr[2] + arr[3]) > 59) {
                return "";
            }
            buffer.append("2");
            for (int i = 3; i > 0; i--) {
                if (arr[i] <= 3) {
                    buffer.append("");
                }
            }
        }
        return "";
    }
}
