package ityoung.tech.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(125);
        list.show();
        list.josephu(10, 20);

    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("num的值不正确，请输入大于0的整数");
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                first = new Boy(1);
                cur = first;
                first.setNext(first);
            } else {
                cur.setNext(new Boy(i));
                cur.getNext().setNext(first);
                cur = cur.getNext();
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("队列为空~~~");
        }
        Boy cur = first;
        while (true) {
            System.out.printf("我是第%d个孩子\n", cur.getNo());
            if (cur.getNext() != first) {
                cur = cur.getNext();
            } else {
                break;
            }
        }
    }

    public void josephu(int k, int num) {
        int count = 0;
        Boy cur = first;
        while (cur.getNext() != first) {
            cur = cur.getNext();
        }
        if (num < 1) {
            System.out.println("输入的约瑟夫序号有误，请重新输入");
        }
        if (k < 1) {
            System.out.println("输入的起点数有误");
            return;
        }
        for (int i = 1; i < k; i++) {
            cur = cur.getNext();
        }
        while (true) {
            if (count != num - 1) {
                cur = cur.getNext();
                count++;
            } else {
                System.out.println(cur.getNext());
                cur.setNext(cur.getNext().getNext());
//                cur = cur.getNext();
                count = 0;
            }
            if (cur.getNext() == cur) {
                System.out.println(cur);
                break;
            }
        }
    }
}

class Boy {
    private Integer no;
    private Boy next;

    public Boy(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
