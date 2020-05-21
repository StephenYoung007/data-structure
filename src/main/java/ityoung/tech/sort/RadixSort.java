package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class RadixSort {

    private static final Logger log = LoggerFactory.getLogger(RadixSort.class);

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArr(8);
        log.info(Arrays.toString(arr));
        radixSort(arr);
        log.info(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int[][] bucketArr = new int[10][arr.length];
        int[] countArr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % 10;
            bucketArr[remainder][countArr[remainder]] = arr[i];
            countArr[remainder]++;
        }
        log.info(Arrays.toString(countArr));
        log.info(Arrays.toString(bucketArr));
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[k] = bucketArr[i][j];
                k++;
            }
        }
    }
}
