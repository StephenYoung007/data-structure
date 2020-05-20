package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MergeSort {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArr(8);
        int[] temp = new int[arr.length];
        log.info(Arrays.toString(arr));
//        sort(0, 3, 7, arr, temp);
        merge(arr, 0, arr.length - 1, temp);
        log.info(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(arr, left, mid, temp);
            merge(arr, mid + 1, right, temp);
            sort(left, mid, right, arr, temp);
        }
    }

    public static void sort(int left, int mid, int right, int[] arr, int[] temp) {
        int i = left;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[cur] = arr[i];
                cur++;
                i++;
            } else {
                temp[cur] = arr[j];
                cur++;
                j++;
            }
        }
        while (i <= mid) {
            temp[cur] = arr[i];
            cur++;
            i++;
        }
        while (j <= right) {
            temp[cur] = arr[j];
            cur++;
            j++;
        }
        cur = 0;
        while (left <= right) {
            arr[left] = temp[cur];
            left++;
            cur++;
        }
    }
}
