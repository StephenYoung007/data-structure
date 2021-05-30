package ityoung.tech.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HanoiTower {
    private static int stepCount = 0;

    public static void main(String[] args) {
        move(20, 'A', 'B', 'C');
    }

    private static void move(int num, char a, char b, char c) {
        if (num == 1) {
            log.info("step {}: disk {} moved from {} to {}", ++stepCount, num, a, c);
        } else {
            move(num - 1, a, c, b);
            log.info("step {}: disk {} moved from {} to {}", ++stepCount, num, a, c);
            move(num - 1, b, a, c);
        }
    }
}
