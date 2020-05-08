package ityoung.tech.linkedlist;

import java.time.temporal.Temporal;
import java.util.Stack;
import java.util.TreeMap;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.add(heroNode4);
        System.out.println("===================================");
        LinkedList sortedLinkedList = new LinkedList();
        sortedLinkedList.addByOrder(heroNode4);
        sortedLinkedList.addByOrder(heroNode2);
        sortedLinkedList.addByOrder(heroNode1);
        sortedLinkedList.addByOrder(heroNode3);
        sortedLinkedList.addByOrder(heroNode3);
        sortedLinkedList.list();
        HeroNode heroNode5 = new HeroNode(3, "没有用", "智多星Stephen");
        HeroNode heroNode6 = new HeroNode(6, "没有用", "智多星Stephen");
        sortedLinkedList.update(heroNode5);
        sortedLinkedList.update(heroNode6);
        sortedLinkedList.list();
        sortedLinkedList.deleteByNo(3);
        sortedLinkedList.list();
        sortedLinkedList.deleteByNo(6);
        sortedLinkedList.list();
        int length = LinkedList.getLength(sortedLinkedList.getHead());
        System.out.printf("length = %d\n", length);
        HeroNode lastIndexNode = LinkedList.findLastIndexNode(sortedLinkedList.getHead(), 4);
        System.out.println(lastIndexNode);
//        LinkedList.reverse(sortedLinkedList);
        sortedLinkedList.list();
        System.out.println("倒叙打印后：");
        sortedLinkedList.reversedList();
        LinkedList sortedLinkedList2 = new LinkedList();
        sortedLinkedList2.addByOrder(heroNode6);
        sortedLinkedList2.addByOrder(heroNode3);
        sortedLinkedList.joinByOrder(sortedLinkedList2);
        System.out.println("排序链表重组");
        sortedLinkedList.list();
    }
}

class LinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void reversedList() {
        HeroNode cur = head.next;
        Stack<HeroNode> heroNodes = new Stack<>();
        while (cur != null) {
            heroNodes.push(cur);
            cur = cur.next;
        }
        while (!heroNodes.empty()) {
            HeroNode node = heroNodes.pop();
            System.out.println(node);
        }
    }

    public static void reverse(LinkedList linkedList) {
        HeroNode head = linkedList.getHead();
        HeroNode temp = null;
        HeroNode reversedHead = new HeroNode(0, "", "");
        while (head.next != null) {
            temp = head.next;
            head.next = temp.next;
            temp.next = reversedHead.next;
            reversedHead.next = temp;
        }
        head.next = reversedHead.next;
    }

    public static int getLength(HeroNode head) {
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        int length = getLength(head);
        int no = length - index;
        if (no < 0) {
            System.out.println("序号超出链表长度");
            return null;
        }
        HeroNode lastIndexNode = head.next;
        while (no > 0) {
            lastIndexNode = lastIndexNode.next;
            no--;
        }
        return lastIndexNode;
    }

    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("队列为空");
            return;
        }
        boolean flag = false;
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("未找到序号为%d的节点\n", heroNode.no);
        }
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void deleteByNo(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("删除成功");
        } else {
            System.out.println("查无此节点，删除失败");
        }
    }

    public void joinByOrder(LinkedList list) {
        HeroNode pointer = list.head.next;
        HeroNode temp = head;
        HeroNode cur = null;
        while (pointer != null) {
            while (true) {
                if (temp.next == null || temp.next.no >= pointer.no) {
                    cur = temp.next;
                    break;
                }
                temp = temp.next;
            }
            HeroNode next = pointer.next;
            temp.next = pointer;
            pointer.next = cur;
            pointer = next;
            if (pointer == null) {
                break;
            }
        }
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.no == heroNode.no) {
                System.out.printf("节点冲突，冲突序号为: %d", heroNode.no);
//                throw new RuntimeException();
                flag = false;
                break;
            }
            if (temp.next == null || temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            heroNode.next = temp.next;
            temp.next = heroNode;
        } else {
            System.out.println("节点已存在，添加失败");
        }
    }

    public void list() {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
