package ityoung.tech.api;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("Stephen", 28);
        countMap.put("Young", 27);
//        countMap.put("Wang", 50);
        countMap.merge("Wang", 1, (oldValue, newValue) -> oldValue + newValue);
        System.out.println(countMap);
    }
}
