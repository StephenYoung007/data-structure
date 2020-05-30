package ityoung.tech.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import static ityoung.tech.sort.RadixSort.radixSort;

public class BinarySearch {
    private static final Logger log = LoggerFactory.getLogger(BinarySearch.class);

    public static void main(String[] args) {
        int[] ori = {5, 7, 9, 2, 4, 6, 1, 3, 8, 9, 9, 9, 5, 5, 5, 5};
        radixSort(ori);
        int target = 5;
        binarySearch(ori, target, 0, ori.length - 1);
    }

    private static Set<Integer> binarySearch(int[] ori, int target, int left, int right) {
        int mid = (left + right) / 2;
        Set set = new HashSet<Integer>();
        if (left > right) {
            log.info("查无此数");
            set.add(-1);
            return set;
        }
        log.info("left = " + left);
        log.info("right = " + right);
        if (ori[mid] > target) {
            return binarySearch(ori, target, left, mid - 1);
        } else if (ori[mid] < target) {
            return binarySearch(ori, target, mid + 1, right);
        } else {
            for (int i = mid; i >= left; i--) {
                if (ori[i] == target) {
                    set.add(i);
                } else {
                    break;
                }
            }
            for (int i = mid; i <= right; i++) {
                if (ori[i] == target) {
                    set.add(i);
                } else {
                    break;
                }
            }
            log.info("要查找的数下标为: " + set);
            return set;
        }
    }
}
