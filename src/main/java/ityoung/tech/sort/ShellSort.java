package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ShellSort {

    private static final Logger log = LoggerFactory.getLogger(ShellSort.class);

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArr(240000);
//        log.info(Arrays.toString(arr));
        int num = arr.length / 2;
        log.info("排序前");
        while (num >= 1) {
//            simpleShellInsertSort(arr, num);
            moveShellInsertSort(arr, num);
            num /= 2;
        }
        log.info("排序后");
//        log.info(Arrays.toString(arr));
    }

    public static int[] simpleShellInsertSort(int[] arr, int num) {
        int temp;
//        log.info(Arrays.toString(arr));
        for (int i = num; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - num; j >= 0; j -= num) {
                if (temp < arr[j]) {
                    arr[j + num] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] moveShellInsertSort(int[] arr, int num) {
        int cur;
        int temp;
//        log.info(Arrays.toString(arr));
        for (int i = num; i < arr.length; i++) {
            temp = arr[i];
            cur = i - num;
            while (cur >= 0 && temp < arr[cur]) {
                arr[cur + num] = arr[cur];
                cur -= num;
            }
            arr[cur + num] = temp;
        }
        return arr;
    }
}
