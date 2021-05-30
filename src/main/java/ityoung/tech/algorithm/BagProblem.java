package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {0, 1, 4, 3};
        int[] price = {0, 1500, 3000, 2000};
        int capacity = 4;
        int maxValue = getMaxValue(capacity, weight, price);
        log.info("the max value for capacity {} is : {}", capacity, maxValue);
    }

    private static int getMaxValue(int capacity, int[] weight, int[] price) {
        return getValues(weight, price, capacity, 3);
    }

    private static int getValues(int[] weight, int[] price, int column, int row) {
        if (column == 0 || row == 0) {
            return 0;
        }
        if (weight[row] > column) {
            return getValues(weight, price, column, row - 1);
        } else {
            if (price[row] + getValues(weight, price, column - weight[row], row - 1) > getValues(weight, price, column, row - 1)) {
                return price[row] + getValues(weight, price, column - weight[row], row - 1);
            } else {
                return getValues(weight, price, column, row - 1);
            }
//            return Math.max(price[row] + getValues(weight, price, column - weight[row], row - 1), getValues(weight, price, column, row - 1));
        }
    }
}
