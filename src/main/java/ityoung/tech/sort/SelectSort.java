package ityoung.tech.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SelectSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000000);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String before = sdf.format(new Date());
        System.out.println("排序前" + before);
//        System.out.println(Arrays.toString(arr));
        int min;
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (min < arr[i]) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
//        System.out.println(Arrays.toString(arr));
        String after = sdf.format(new Date());
        System.out.println("排序后" + after);
    }
}
