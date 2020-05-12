package ityoung.tech.sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            int num = random.nextInt(8000000);
            arr[i] = num;
        }
        int temp;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String before = sdf.format(new Date());
        System.out.println("排序前" + before);
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
