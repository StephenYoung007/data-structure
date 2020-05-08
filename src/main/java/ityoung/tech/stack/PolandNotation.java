package ityoung.tech.stack;

import java.util.*;

public class PolandNotation {
    public static void main(String[] args) {
        /*String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        String[] s = suffixExpression.split(" ");
        List<String> list = Arrays.asList(s);
        System.out.println("rpnList = " + list);
        int res = calculate(list);
        System.out.println(suffixExpression + " = " + res);*/
        String expression = "81+9-5*(44-3)";
        List<String> list = toInfixExpression(expression);
        System.out.println(list);
        List<String> suffixList = infixToSuffix(list);
        System.out.println(suffixList);
        int res = calculate(suffixList);
        System.out.println(expression + " = " + res);
    }

    public static List<String> infixToSuffix(List<String> infix) {
        Stack<String> numStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        for (String s : infix) {
            if (s.matches("\\d+")) {
                numStack.push(s);
            } else if (isOper(s.charAt(0))){
                while (true) {
                    if (operStack.isEmpty() || operStack.peek() == "(" || priority(s.charAt(0)) > priority(operStack.peek().charAt(0))) {
                        operStack.push(s);
                        break;
                    } else {
                        numStack.push(operStack.pop());
                    }
                }
            } else if (s.equals("(")) {
                operStack.push(s);
            } else if (s.equals(")")) {
                while (true) {
                    if (!"(".equals(operStack.peek())) {
                        numStack.push(operStack.pop());
                    } else {
                        operStack.pop();
                        break;
                    }
                }
            } else {
                System.out.println("操作符不对");
            }
        }
        while (!operStack.isEmpty()) {
            numStack.push(operStack.pop());
        }
        return new ArrayList<>(numStack);
    }

    public static boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int priority(int ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else {
//            System.out.println("输入不合法");
            return -1;
        }
    }

    public static List<String> toInfixExpression(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("\\d+") && i > 0 && split[i - 1].matches("\\d+")) {
                    String pop = stack.pop();
                    stack.push(10 * Integer.parseInt(pop) + Integer.parseInt(split[i]) + "");
                } else {
                    stack.push(split[i]);
            }
        }
        return new ArrayList<>(stack);
    }

    private static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String ele : list) {
            if (ele.matches("\\d+")) {
                stack.push(ele);
            } else if (ele.equals("+")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(Integer.parseInt(num1) + Integer.parseInt(num2) + "");
            } else if (ele.equals("-")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(Integer.parseInt(num1) - Integer.parseInt(num2) + "");
            } else if (ele.equals("*")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(Integer.parseInt(num1) * Integer.parseInt(num2) + "");
            } else if (ele.equals("/")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(Integer.parseInt(num1) / Integer.parseInt(num2) + "");
            } else {
                System.out.println("操作符有误，请重新输入");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
