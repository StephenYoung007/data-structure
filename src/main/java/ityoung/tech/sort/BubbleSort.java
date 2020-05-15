package ityoung.tech.sort;

import ityoung.tech.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static ityoung.tech.util.ArrayUtil.getRandomArr;


public class BubbleSort {

    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int[] arr = getRandomArr(80000);
        int temp;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String before = sdf.format(new Date());
        System.out.println("排序前" + before);
        logger.info("排序前" + before);
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        String after = sdf.format(new Date());
        System.out.println("排序后" + after);
    }
}
