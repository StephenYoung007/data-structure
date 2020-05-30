package ityoung.tech.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static ityoung.tech.sort.RadixSort.radixSort;

public class FibonacciSearch {

    private static final Logger log = LoggerFactory.getLogger(BinarySearch.class);

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] ori = {5, 7, 9, 2, 4, 6, 1, 3, 8, 13, 11, 19, 12, 10, 14, 16, 15, 18, 20, 17};
        radixSort(ori);
        int target = 17;
        int search = fibonacciSearch(ori, target);
        log.info("目标数在查找数组的下标为: " + search);
    }

    private static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        log.info("斐波那契数组为: " + Arrays.toString(f));
        return f;
    }

    private static int fibonacciSearch(int[] ori, int target) {
        int[] f = fib();
        int low = 0;
        int high = ori.length - 1;
        int k = 0;
        int mid = 0;
        while (f[k] < high) {
            k++;
        }
        int[] temp = Arrays.copyOf(ori, f[k]);
        for (int i = high; i < f[k]; i++) {
            temp[i] = ori[high];
        }
        log.info("构造的斐波那契长度临时数组为" + Arrays.toString(temp));
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            log.info("low = " + low + " high = " + high + " mid = " + mid);
            if (target < ori[mid]) {
                high = mid - 1;
                k--;
            } else if (target > ori[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid > high) {
                    return high;
                } else {
                    log.info("====================================");
                    return mid;
                }
            }
        }
        return -1;
    }
}
