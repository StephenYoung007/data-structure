package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static ityoung.tech.util.ArrayUtil.getRandomArr;

public class InsertSort {
    private static final Logger log = LoggerFactory.getLogger(InsertSort.class);

    public static void main(String[] args) {
        int[] arr = getRandomArr(240000);
//        log.info(Arrays.toString(arr));
        exchangeInsertSort(arr);
//        log.info(Arrays.toString(arr));
        arr = getRandomArr(240000);
//        log.info(Arrays.toString(arr));
        moveInsertSort(arr);
//        log.info(Arrays.toString(arr));
    }

    public static void exchangeInsertSort(int[] arr) {
        int cur;
        int temp;
        log.info("排序前");
//        log.info(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            cur = i - 1;
            while (cur >= 0 && arr[cur] > temp) {
                arr[cur + 1] = arr[cur];
                cur--;
            }
            arr[cur + 1] = temp;
        }
        log.info("排序后");
//        log.info(Arrays.toString(arr));
    }

    public static void moveInsertSort(int[] arr) {
        int temp;
        log.info("排序前");
//        log.info(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
//        log.info(Arrays.toString(arr));
        log.info("排序后");
    }



}
