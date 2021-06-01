package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class EightQueen {
    private static List<List<Integer>> container =new ArrayList();

    public static void main(String[] args) {
        int[][] track = new int[8][8];
        backtracking(track);
        for (int i = 0; i < container.size(); i++) {
            log.info(container.get(i).toString());
        }
    }

    private static void backtracking(List<Integer> nums, int[][] track) {
        for (int i = 0; i < nums.size(); i++) {
            /**
             * 找到底端，终止当前路径
             */
            if (track.size() == nums.size()) {
                container.add(new LinkedList<>(track));
                return;
            }
            /**
             * 以及选择过的路径，跳过
             */
            if (track.contains(i)) {
                continue;
            }
            /**
             * 选择当前路径
             */
            track.add(i);
            /**
             * 继续探索下一个路径
             */
            backtracking(nums, track);
            /**
             * 移除已经终止返回的路径
             */
            track.removeLast();
        }
    }
}
