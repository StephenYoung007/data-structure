package ityoung.tech.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.prefs.NodeChangeEvent;

public class ArrayUtil {

    public static int[] getRandomArr(int total) {
        Random random = new Random();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            int num = random.nextInt(100 * total);
            arr[i] = num;
        }
        return arr;
    }

    public static String now(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = sdf.format(new Date());
        return msg + " :" + now;
    }
}
