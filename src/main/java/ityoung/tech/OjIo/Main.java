package ityoung.tech.OjIo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return;
        }
        Random random = new Random(10);
        int anInt = random.nextInt();
        List<People> peopleList = new ArrayList<>();
        People[] peopleArray = new People[100];
        for (int i = 1; i <= 100; i++) {
            peopleList.add(new People(i));
            peopleArray[i - 1] = peopleList.get(i - 1);
        }
        for (int i = 1; i < peopleList.size() - 1; i++) {
            peopleList.get(i).setNext(peopleList.get(i + 1));
            peopleList.get(i).setPre(peopleList.get(i - 1));
        }
        peopleList.get(0).setNext(peopleList.get(1));
        peopleList.get(99).setNext(peopleList.get(0));
        peopleList.get(99).setPre(peopleList.get(98));/*
        int n = 100;
        People head = peopleList.get(0);
        while (n >= m) {
            int count = 1;
            while (count < m) {
                head = head.getNext();
            }
            int index = head.getNext().getNumber();
            peopleArray[index - 1] = null;
        }*/
        int start = 0;
        int k = 0;
        for (int i = 100; i >= m; i--) {
            k = (start + m) % i;
            k = k == 0 ? i : k;
            removeByNumber(k, peopleList);
            start = k;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(peopleList.get(0).getNumber());
        for (int i = 0; i < peopleArray.length; i++) {
            if (peopleArray[i] != null) {
                buffer.append(",");
                buffer.append(peopleList.get(i).getNumber());
            }
        }
        System.out.println(buffer);
    }

    private static void removeByNumber(int k, List<People> peopleList) {
        peopleList.remove(k);
    }
}

class People {
    private int number;
    private People next;
    private People pre;

    public People(int number) {
        this.number = number;
    }

    public People getNext() {
        return next;
    }

    public People getPre() {
        return pre;
    }

    public void setNext(People next) {
        this.next = next;
    }

    public void setPre(People pre) {
        this.pre = pre;
    }

    public int getNumber() {
        return number;
    }
}
