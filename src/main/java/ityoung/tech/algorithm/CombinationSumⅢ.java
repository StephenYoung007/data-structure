package ityoung.tech.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumⅢ {
    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<Integer> path = new ArrayList<>();
        backTrace(path, k, target, 9, 0);
        return paths;
    }

    private void backTrace(List<Integer> path, int size, int sum, int range, int cur) {
        int currentSum = path.stream().mapToInt(Integer::intValue).sum();
        if (path.size() == size && currentSum == sum) {
            paths.add(new ArrayList<>(path));
            return;
        }
        if (currentSum >= sum || path.size() >= size) {
            return;
        }
        for (int i = cur; i < range; i++) {
            int candidate = i + 1;
            if (path.contains(candidate)) {
                continue;
            }
            path.add(candidate);
            cur++;
            backTrace(path, size, sum, range, cur);
            path.remove(path.size() - 1);
        }
    }
}
