package ityoung.tech.algorithm;

import ityoung.tech.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class BinarySearchWithoutRecursion {
    public static void main(String[] args) {
        int[] sortedArr = ArrayUtil.getSortedArr(10);
        log.info(Arrays.toString(sortedArr));
        int cursor = binarySearch(sortedArr, sortedArr[6]);
        System.out.println(cursor);
    }

    private static int binarySearch(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedArr[mid] == target) {
                log.info("查找次数为：{}", count);
                return mid;
            } else if (sortedArr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
            count++;
        }
        return  -1;
    }
}
