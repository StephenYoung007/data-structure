package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class PermutationSequence {
    public static void main(String[] args) {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);
    }

    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> container = new ArrayList();
        backtracking(nums, track, container, k);
        StringBuilder builder = new StringBuilder();
/*        for (int i = 0; i < container.size(); i++) {
            log.info(container.get(i) + "");
        }*/
        container.get(k - 1).stream().forEach(ele -> {
            builder.append(ele);
        });
        return builder.toString();
    }

    private static void backtracking(List<Integer> nums, LinkedList<Integer> track, List<List<Integer>> container, int k) {
        for (int i = 0; i < nums.size(); i++) {
            /**
             * 找到底端，终止当前路径
             */
            if (track.size() == nums.size()) {
                if (container.size() == k - 1) {
                    container.add(new ArrayList<>(track));
                } else {
                    container.add(null);
                }
                return;
            }
            /**
             * 以及选择过的路径，跳过
             */
            if (track.contains(nums.get(i))) {
                continue;
            }
            /**
             * 选择当前路径
             */
            track.add(nums.get(i));
            /**
             * 继续探索下一个路径
             */
            backtracking(nums, track, container, k);
            /**
             * 移除已经终止返回的路径
             */
            track.removeLast();
        }
    }
}
