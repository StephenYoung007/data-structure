package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class KMPMatch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDDE";
        String str2 = "ABCDABD";
        int[] partMatchTable = getPartMatchTable(str2);
        log.info(Arrays.toString(partMatchTable));
        int index = match(str1, str2);
        int index2 = matchByKMP(str1, str2, partMatchTable);
        log.info("starting at {}", index);
        log.info("starting at {}", index2);
    }

    private static int matchByKMP(String origin, String matcher, int[] partMatchTable) {
        int i = 0;
        int j = 0;
        while (i < origin.length() && j < matcher.length()) {
            if (origin.charAt(i) == matcher.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + partMatchTable[j] + 1;
                j = 0;
            }
        }
        if (j == matcher.length()) {
            return i - matcher.length();
        } else {
            return -1;
        }
    }

    private static int match(String origin, String matcher) {
        for (int i = 0; i < origin.length(); i++) {
            int cursor = i;
            for (int j = 0; j < matcher.length(); j++) {
                if (origin.charAt(cursor) == matcher.charAt(j)) {
                    if (j == matcher.length() - 1) {
                        return i;
                    } else {
                        cursor++;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    private static int[] getPartMatchTable(String str) {
        int[] partMatchTable = new int[str.length()];
        partMatchTable[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = partMatchTable[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            partMatchTable[i] = j;
        }
        return partMatchTable;
    }
}