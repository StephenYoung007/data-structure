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
        int[] arr = getRandomArr(800000);
        int cur;
        int temp;
        log.info("排序前");
//        log.info(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            cur = i - 1;
            /*for (int j = i - 1; j >= 0; j--) {
                if (cur < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = cur;
                }
            }*/
            while (cur >= 0 && arr[cur] > temp) {
                arr[cur + 1] = arr[cur];
                cur--;
            }
            arr[cur + 1] = temp;
        }
        log.info("排序后");
//        log.info(Arrays.toString(arr));
    }
}
