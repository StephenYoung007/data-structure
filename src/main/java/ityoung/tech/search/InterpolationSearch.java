package ityoung.tech.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import static ityoung.tech.sort.RadixSort.radixSort;

public class InterpolationSearch {

    private static final Logger log = LoggerFactory.getLogger(InterpolationSearch.class);

    public static void main(String[] args) {
        int[] ori = {5, 7, 9, 2, 4, 6, 1, 3, 8, 13, 11, 19, 12, 10, 14, 16, 15, 18, 20, 17};
        radixSort(ori);
        int target = 5;
        interpolationSearch(ori, target, 0, ori.length - 1);
    }

    private static Set<Integer> interpolationSearch(int[] ori, int target, int left, int right) {
//        int mid = (left + right) / 2;
        int mid = left + (target - ori[left]) * (right - left) / (ori[right] - ori[left]);
        Set set = new HashSet<Integer>();
        if (left > right) {
            log.info("查无此数");
            set.add(-1);
            return set;
        }
        log.info("left = " + left);
        log.info("right = " + right);
        if (ori[mid] > target) {
            return interpolationSearch(ori, target, left, mid - 1);
        } else if (ori[mid] < target) {
            return interpolationSearch(ori, target, mid + 1, right);
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
