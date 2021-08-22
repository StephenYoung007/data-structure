package ityoung.tech.algorithm;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> positions = new ArrayDeque();
        Set<Integer> arrived = new HashSet<>();
        positions.offer(start);
        boolean flag = false;
        b:
        while (!positions.isEmpty()) {
            Integer currentPosition = positions.poll();
            arrived.add(currentPosition);
            if (arr[currentPosition] == 0) {
                flag = true;
                break b;
            }
            int step = arr[currentPosition];
            if ((currentPosition + step) <= arr.length - 1 && !arrived.contains(currentPosition + step)) {
                positions.offer(currentPosition + step);
            }
            if ((currentPosition - step) >= 0 && !arrived.contains(currentPosition - step)) {
                positions.offer(currentPosition - step);
            }
        }
        return flag;
    }
}
