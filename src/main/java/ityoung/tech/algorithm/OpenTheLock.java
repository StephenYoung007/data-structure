package ityoung.tech.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/*
["0201","0101","0102","1212","2002"]
"5405"
* */

public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadends = {"8888"};
        int i = openLock(deadends, "0033");
        System.out.println(i);
    }
    public static int openLock(String[] deadends, String target) {
        Set<String> headArrived = new HashSet<>();
        Set<String> tailArrived = new HashSet<>();
        Set<String> deads = Arrays.asList(deadends).stream().collect(Collectors.toSet());
        if (deads.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> headLevel = new ArrayDeque<>();
        Queue<String> tailLevel = new ArrayDeque<>();
        headLevel.offer("0000");
        tailLevel.offer(target);
        int headCount = 0;
        int tailCount = 0;
        boolean flag = false;
        b:
        while (!headLevel.isEmpty() && !tailLevel.isEmpty()) {
            int headSize = headLevel.size();
            int tailSize = tailLevel.size();
            for (int i = 0; i < headSize; i++) {
                String poll = headLevel.poll();
                if (tailArrived.contains(poll)) {
                    flag = true;
                    break b;
                }
                for (int j = 0; j < 4; j++) {
                    int d = (poll.charAt(j) - '0');

                    int inc = d == 9 ? 0 : d + 1;
                    int dec = d == 0 ? 9 : d - 1;
                    String increased = poll.substring(0, j) + (char) (inc + '0') + poll.substring(j + 1);
                    String decreased = poll.substring(0, j) + (char) (dec + '0') + poll.substring(j + 1);

                    if (headArrived.contains(increased) == false && deads.contains(increased) == false) {
                        headLevel.offer(increased);
                        headArrived.add(increased);
                    }
                    if (headArrived.contains(decreased) == false && deads.contains(decreased) == false) {
                        headLevel.offer(decreased);
                        headArrived.add(decreased);
                    }
                }
            }
            headCount++;
            for (int i = 0; i < tailSize; i++) {
                String poll = tailLevel.poll();
                if (headArrived.contains(poll)) {
                    flag = true;
                    break b;
                }
                for (int j = 0; j < 4; j++) {
                    int d = (poll.charAt(j) - '0');

                    int inc = d == 9 ? 0 : d + 1;
                    int dec = d == 0 ? 9 : d - 1;
                    String increased = poll.substring(0, j) + (char) (inc + '0') + poll.substring(j + 1);
                    String decreased = poll.substring(0, j) + (char) (dec + '0') + poll.substring(j + 1);

                    if (tailArrived.contains(increased) == false && deads.contains(increased) == false) {
                        tailLevel.offer(increased);
                        tailArrived.add(increased);
                    }
                    if (tailArrived.contains(decreased) == false && deads.contains(decreased) == false) {
                        tailLevel.offer(decreased);
                        tailArrived.add(decreased);
                    }
                }
            }
            tailCount++;
        }
        return flag == true ? headCount + tailCount : -1;
    }
}
