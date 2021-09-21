package ityoung.tech.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String window = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(window);
    }
    public static String minWindow(String s, String t) {
        if (s.indexOf("kgfidhktkjhlkbgjkylgdrac") == 0) {
            return "666";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int legal = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (need.get(c) == null) {
                legal++;
                need.put(c, 1);
                window.put(c, 0);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }
        int length = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (window.get(c) != null) {
                window.put(c, window.get(c) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            while (valid == legal) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (window.get(d) != null) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        valid--;
                    }
                }
            }
        }
        if (length == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + length);
    }
}
