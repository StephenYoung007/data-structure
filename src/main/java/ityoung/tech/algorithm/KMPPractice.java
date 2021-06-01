package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class KMPPractice {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDDE";
        String str2 = "ABCDABD";
//        String str2 = "ABCDEABCDABCDE";
//        String str2 = "AAAA";
        int[] matchTable = getMatchTable(str2);
        log.info(Arrays.toString(matchTable));
        int cur = kmpMatch(str1, str2);
        log.info("match begin at {}", cur);
    }

    private static int kmpMatch(String haystack, String needle) {
        int j = 0;
        int i = 0;
        if (haystack == "" || needle == "") {
            return -1;
        }
        int[] matchTable = getMatchTable(needle);
        for (i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = matchTable[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                break;
            }
        }
        if (j == needle.length()) {
            return i-j+1;
        } else {
            return -1;
        }
    }

    private static int[] getMatchTable(String matcher) {
        int[] matchTable = new int[matcher.length()];
        matchTable[0] = 0;
        for (int i = 1, j = 0; i < matchTable.length; i++) {
            while (j > 0 && matcher.charAt(i) != matcher.charAt(j)) {
                j = matchTable[j - 1];
            }
            if (matcher.charAt(i) == matcher.charAt(j)) {
                j++;
            }
            matchTable[i] = j;
        }
        return matchTable;
    }
}
