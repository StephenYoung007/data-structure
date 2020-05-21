package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class QuickSort {

    private static Logger log = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArr(8);
        log.info("排序前");
        log.info(Arrays.toString(arr));
        int l = 0;
        int r = arr.length - 1;
        recursionSort(arr, l, r);
        log.info("排序后");
        log.info(Arrays.toString(arr));
    }

    private static void recursionSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
            log.info(Arrays.toString(arr));
        }
        if (l == r)
//        l++;
//        r--;
        log.info(Arrays.toString(arr));
        log.info("left: " + left + " | " + "right: " + right);
        log.info("l: " + l + " | " + "r: " + r);
/*        System.out.println();
        if (left < r) {
            recursionSort(arr, left, r);
        }
        if (right > l) {
            recursionSort(arr, l, right);
        }*/

    }
}
