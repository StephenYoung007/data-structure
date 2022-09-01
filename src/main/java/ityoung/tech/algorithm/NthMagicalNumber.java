package ityoung.tech.algorithm;

public class NthMagicalNumber {
    public static int nthMagicalNumber(int n, int a, int b) {
        long value = 0;
        if (a == b) {
            long c = a;
            value = n * c;
            return (int) (value % 1000000007);
        }
        int count = 0;
        for (long i = 2; i < Long.MAX_VALUE; i++) {
            if (i % a == 0 || i % b == 0) {
                count++;
                if (count == n) {
                    value = i;
                    break;
                }
            }
        }
        return (int) (value % (1000000007));
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1000000000, 4000, 4000));
    }
}
