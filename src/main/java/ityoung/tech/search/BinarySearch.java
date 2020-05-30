package ityoung.tech.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ityoung.tech.sort.RadixSort.radixSort;

public class BinarySearch {
    private static final Logger log = LoggerFactory.getLogger(BinarySearch.class);

    public static void main(String[] args) {
        int[] ori = {5, 7, 9, 2, 4, 6, 1, 3, 8};
        radixSort(ori);
        int target = 9;
        binarySearch(ori, target, 0, ori.length - 1);
    }

    private static int binarySearch(int[] ori, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) {
            log.info("查无此数");
            return -1;
        }
        log.info("left = " + left);
        log.info("right = " + right);
        if (ori[mid] > target) {
            binarySearch(ori, target, left, mid - 1);
        } else if (ori[mid] < target) {
            binarySearch(ori, target, mid + 1, right);
        } else if (ori[mid] == target) {
            log.info("要查找的数下标为: " + mid);
            return mid;
        }
        return -1;
    }
}
