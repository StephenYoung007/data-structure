package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class RadixSort {

    private static final Logger log = LoggerFactory.getLogger(RadixSort.class);

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArr(80000000);
//        log.info(Arrays.toString(arr));
        log.info("排序前......");
        radixSort(arr);
//        log.info(Arrays.toString(arr));
        log.info("排序后......");
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[][] bucketArr = new int[10][arr.length];
        int[] countArr = new int[10];
        int maxLength = (max + "").length();
        int currentRound = 0;
        int n = 1;
        while (currentRound < maxLength) {
            for (int i = 0; i < arr.length; i++) {
                int remainder = arr[i] / n % 10;
                bucketArr[remainder][countArr[remainder]] = arr[i];
                countArr[remainder]++;
            }
//            log.info(Arrays.toString(countArr));
            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < countArr[i]; j++) {
                    arr[k] = bucketArr[i][j];
                    k++;
                }
                countArr[i] = 0;
            }
            currentRound++;
            n *= 10;
//            log.info(Arrays.toString(arr));
        }
    }
}
