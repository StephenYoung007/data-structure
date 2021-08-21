package ityoung.tech.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumⅡ {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 10, 2, 7, 6, 1, 5};
        combinationSum2(candidates, 8);
        System.out.println(paths);
    }

    private static List<List<Integer>> paths = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(path, target, candidates, 0);
        return paths;
    }

    private static void backTrace(List<Integer> path, int sum, int[] candidates, int cur) {
        int currentSum = path.stream().mapToInt(Integer::intValue).sum();
        if (currentSum == sum) {
            paths.add(new ArrayList<>(path));
            return;
        }
        if (currentSum > sum) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            int candidate = candidates[i];
            int count = 1;
            for (int j = i; j >= 1; j--) {
                if (candidates[j - 1] == candidate) {
                    count++;
                } else {
                    break;
                }
            }
            int count2 = count;
            while (count > 0) {
                path.add(candidate);
                count--;
            }
            cur = i;
            for (int j = i; j < candidates.length - 1; j++) {
                if (candidates[j + 1] == candidate) {
                    cur++;
                } else {
                    break;
                }
            }
            cur++;
            backTrace(path, sum, candidates, cur);
            while (count2 > 0) {
                path.remove(path.size() - 1);
                count2--;
            }
            cur--;
        }
    }
}
