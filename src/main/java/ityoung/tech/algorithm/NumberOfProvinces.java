package ityoung.tech.algorithm;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> arrived = new HashSet<>();
        int num = isConnected.length;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (!arrived.contains(i)) {
                count++;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        Integer poll = q.poll();
                        if (!arrived.contains(poll)) {
                            arrived.add(poll);
                            for (int k = 0; k < num; k++) {
                                if (isConnected[poll][k] == 1 && !arrived.contains(k)) {
                                    q.offer(k);
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
