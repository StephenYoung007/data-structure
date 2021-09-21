package ityoung.tech.algorithm;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        int oneCount;
        int zeroCount;
        boolean flag = true;
        for (int i = 0; i < strs.length; i++) {
            flag = true;
            oneCount = 0;
            zeroCount = 0;
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (oneCount > n || zeroCount > m) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
