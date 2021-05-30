package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringMatchByViolence {
    public static void main(String[] args) {
        String origin = "你是个小王八放屁王八蛋";
        String matcher = "王八蛋";
        int i = match(origin, matcher);
        log.info("the matcher starts in {}", i);
    }

    private static int match(String origin, String matcher) {
        for (int i = 0; i < origin.length(); i++) {
            int cur = i;
            for (int j = 0; j < matcher.length(); j++) {
                if (matcher.charAt(j) != origin.charAt(cur)) {
                    break;
                }else {
                    cur++;
                }
                if (j == matcher.length() - 1) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
