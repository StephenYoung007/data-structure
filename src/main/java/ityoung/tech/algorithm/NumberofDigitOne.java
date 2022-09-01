package ityoung.tech.algorithm;

public class NumberofDigitOne {
    public static void main(String[] args) {
        /**
         * 13 : 3 + 1 + 1 = 5
         * 24 : 2 + 1 + 4 +
         */
        int countDigitOne = countDigitOne(13);
        System.out.println(countDigitOne);
    }
    public static int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int count = 0;
        int total = 0;
        int level = 1;
        while (n >= 10) {
            total = level * (n % 10) + total;
            level *= 10;
            if (n % 10 == 0) {
                n /= 10;
                count += countDigitOne(n);
            } else {
                n /= 10;
                count = count + countDigitOne(n) + n + 1;
            }
        }
        count = total + count;
        return count;
    }
}
