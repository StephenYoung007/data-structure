package ityoung.tech.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "53+6*2-2*2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1;
        int num2;
        char ch;
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    int pop = operStack.peek();
                    if (operStack.priority(ch) <= operStack.priority(pop)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int oper = operStack.pop();
                        int res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                if (index > 0 && !operStack.isOper(expression.substring(index - 1, index).charAt(0))) {
                    int pop = numStack.pop();
                    numStack.push(pop * 10 + ch - 48);
                } else {
                    numStack.push(ch - 48);
                }
            }
            index++;
            if (index == expression.length() ) {
                break;
            }
        }
        numStack.show();
        operStack.show();
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            int oper = operStack.pop();
            int res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }


}

class ArrayStack2 {
    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack2(int maxSize) {
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

    public int peek() {
        return stack[top];
    }

    public boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int priority(int ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else {
            System.out.println("输入不合法");
            return -1;
        }
    }

    public int cal(int num1, int num2, int oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }
}

