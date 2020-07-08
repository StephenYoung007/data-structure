package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class HeapSort {

    private static Logger log = LoggerFactory.getLogger(HeapSort.class);

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 6, 0, 2, 8, 9, 3, 4};
//        int[] arr = ArrayUtil.getRandomArr(80000000);
        log.info("排序前~~~");
        heapSort(arr);
        log.info("排序后~~~");
        log.info(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
/*        for (int range = arr.length; range > 0; range--) {

            int temp;
            for (int j = range / 2 - 1; j >= 0; j--) {
                adjust(arr, j, range);
            }
            temp = arr[0];
            arr[0] = arr[range - 1];
            arr[range - 1] = temp;
        }*/
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }

    }

    private static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[i] <= arr[k]) {
                arr[i] = arr[k];
                arr[k] = temp;
            }
            i = k;
        }
        log.info(Arrays.toString(arr));

    }
}
