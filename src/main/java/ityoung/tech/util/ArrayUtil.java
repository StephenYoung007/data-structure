package ityoung.tech.util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.prefs.NodeChangeEvent;
import java.util.stream.Collectors;

public class ArrayUtil {

    public static int[] getRandomArr(int total) {
        Random random = new Random();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            int num = random.nextInt(10 * total);
            arr[i] = num;
        }
        return arr;
    }

    public static String now(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = sdf.format(new Date());
        return msg + " :" + now;
    }

    public static int[] getSortedArr(int total) {
        Random random = new Random();
        List<Integer> randomList = new ArrayList<Integer>();
        while (randomList.size() < total) {
            int num = random.nextInt(10 * total);
            if (randomList.contains(num)) {
                continue;
            } else {
                randomList.add(num);
            }
        };
        randomList.sort(Integer::compareTo);
        int[] arr = new int[total];
        for (int i = 0; i < randomList.size(); i++) {
            arr[i] = randomList.get(i);
        }
        return arr;
    }
}
