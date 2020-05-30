package ityoung.tech.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeqSearch {

    private static final Logger log = LoggerFactory.getLogger(SeqSearch.class);

    public static void main(String[] args) {
        int[] ori = {5, 7, 9, 2, 4, 6, 1, 3, 8};
        int target = 8;
        seqSearch(ori, target);
    }

    private static int seqSearch(int[] ori, int target) {
        for (int i = 0; i < ori.length; i++) {
            if (ori[i] == target) {
                log.info("要查找的数下标为: " + i);
                return i;
            }
        }
        log.info("查无此数");
        return -1;
    }
}
