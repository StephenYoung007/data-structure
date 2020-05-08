package ityoung.tech.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[3][5] = 1;
        chessArr[4][8] = 2;
        chessArr[7][6] = 2;
        arrPrint(chessArr);

        int count = 0;
        for (int[] row : chessArr) {
            for (int i : row) {
                if (i != 0) {
                    count++;
                }
            }
        }

        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = count;
        int num = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = chessArr[i][j];
                    num++;
                }
            }
        }
        arrPrint(sparseArr);
    }

    private static void arrPrint(int[][] chessArr) {
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
