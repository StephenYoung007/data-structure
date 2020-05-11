package ityoung.tech.recursion;

public class Quene8 {

    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Quene8 quene8 = new Quene8();
        quene8.check(0);
        System.out.println("八皇后问题的解法总共有: " + count);
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    public void check(int n) {
        if (n == max) {
            quenePrint();
            count++;
//            System.out.println(array);
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private void quenePrint() {
        int[][] quene = new int[max][max];
        for (int i = 0; i < max; i++) {
            quene[i][array[i]] = 1;
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                System.out.print(quene[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }
}
