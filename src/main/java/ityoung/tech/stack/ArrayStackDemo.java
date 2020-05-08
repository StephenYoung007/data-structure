package ityoung.tech.stack;

import java.time.temporal.ValueRange;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        System.out.println(stack.isEmpty());;
        System.out.println(stack.isFull());;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();
        stack.push(5);
        System.out.println(stack.isFull());
        int pop = stack.pop();
        System.out.println(pop);
    }
}

class ArrayStack {
    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = 0; i <= top; i++) {
            System.out.printf("栈的第%d个元素是: %d", i, stack[top - i]);
            System.out.println();
        }
    }
}
