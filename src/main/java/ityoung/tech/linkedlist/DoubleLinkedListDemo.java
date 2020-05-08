package ityoung.tech.linkedlist;

import java.util.Stack;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        System.out.println("===================================");
        DoubleLinkedList sortedDoubleLinkedList = new DoubleLinkedList();
        sortedDoubleLinkedList.addByOrder(heroNode4);
        sortedDoubleLinkedList.addByOrder(heroNode2);
        sortedDoubleLinkedList.addByOrder(heroNode1);
        sortedDoubleLinkedList.addByOrder(heroNode3);
        sortedDoubleLinkedList.addByOrder(heroNode3);
        sortedDoubleLinkedList.list();
        HeroNode2 heroNode5 = new HeroNode2(3, "没有用", "智多星Stephen");
        HeroNode2 heroNode6 = new HeroNode2(6, "没有用", "智多星Stephen");
        sortedDoubleLinkedList.update(heroNode5);
        sortedDoubleLinkedList.update(heroNode6);
        sortedDoubleLinkedList.list();
        sortedDoubleLinkedList.deleteByNo(3);
        sortedDoubleLinkedList.list();
        sortedDoubleLinkedList.deleteByNo(6);
        sortedDoubleLinkedList.list();
        int length = DoubleLinkedList.getLength(sortedDoubleLinkedList.getHead());
        System.out.printf("length = %d\n", length);
        HeroNode2 lastIndexNode = DoubleLinkedList.findLastIndexNode(sortedDoubleLinkedList.getHead(), 5);
        System.out.println("lastIndexNode : \n" + lastIndexNode);
//        DoubleLinkedList.reverse(sortedDoubleLinkedList);
        sortedDoubleLinkedList.list();
        System.out.println("倒叙打印后：");
        sortedDoubleLinkedList.reversedList();
        DoubleLinkedList sortedDoubleLinkedList2 = new DoubleLinkedList();
        sortedDoubleLinkedList2.addByOrder(heroNode6);
        sortedDoubleLinkedList2.addByOrder(heroNode3);
        HeroNode2 heroNode7 = new HeroNode2(2, "卢俊义", "玉麒麟");
        sortedDoubleLinkedList2.addByOrder(heroNode7);
        sortedDoubleLinkedList.joinByOrder(sortedDoubleLinkedList2);
        System.out.println("排序链表重组");
        sortedDoubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void reversedList() {
        HeroNode2 cur = head.next;
        Stack<HeroNode2> HeroNode2s = new Stack<>();
        while (cur != null) {
            HeroNode2s.push(cur);
            cur = cur.next;
        }
        while (!HeroNode2s.empty()) {
            HeroNode2 node = HeroNode2s.pop();
            System.out.println(node);
        }
    }

    public static void reverse(DoubleLinkedList DoubleLinkedList) {
        HeroNode2 head = DoubleLinkedList.getHead();
        HeroNode2 temp = null;
        HeroNode2 reversedHead = new HeroNode2(0, "", "");
        while (head.next != null) {
            temp = head.next;
            head.next = temp.next;
            temp.next = reversedHead.next;
            reversedHead.next = temp;
        }
        head.next = reversedHead.next;
    }

    public static int getLength(HeroNode2 head) {
        int length = 0;
        HeroNode2 cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static HeroNode2 findLastIndexNode(HeroNode2 head, int index) {
        /*int length = getLength(head);
        int no = length - index;
        if (no < 0) {
            System.out.println("序号超出链表长度");
            return null;
        }
        HeroNode2 lastIndexNode = head.next;
        while (no > 0) {
            lastIndexNode = lastIndexNode.next;
            no--;
        }
        return lastIndexNode;*/
        HeroNode2 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        while (index > 1) {
            if (cur == null || cur.pre == null) {
                System.out.println("越界异常");
                break;
            }
            cur = cur.pre;
            index--;
        }
        return cur;
    }

    public void update(HeroNode2 HeroNode2) {
        if (head.next == null) {
            System.out.println("队列为空");
            return;
        }
        boolean flag = false;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == HeroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            temp.name = HeroNode2.name;
            temp.nickName = HeroNode2.nickName;
        } else {
            System.out.printf("未找到序号为%d的节点\n", HeroNode2.no);
        }
    }

    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    public void deleteByNo(int no) {
        HeroNode2 temp = head;
        /*boolean flag = false;
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
            if (temp.next != null) {
                temp.next.pre = temp;
            }
            System.out.println("删除成功");
        } else {
            System.out.println("查无此节点，删除失败");
        }*/
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp;
            }
            System.out.println("删除成功");
        } else {
            System.out.println("查无此节点，删除失败");
        }
    }

    public void joinByOrder(DoubleLinkedList list) {
        HeroNode2 pointer = list.head.next;
        HeroNode2 temp = head;
        HeroNode2 cur = null;
        while (pointer != null) {
            while (true) {
                if (temp.next == null || temp.next.no > pointer.no) {
                    cur = temp.next;
                    break;
                }
                temp = temp.next;
            }
            HeroNode2 next = pointer.next;
            temp.next = pointer;
            pointer.next = cur;
            pointer = next;
            if (pointer == null) {
                break;
            }
        }
    }

    public void addByOrder(HeroNode2 HeroNode2) {
        HeroNode2 temp = head;
        boolean flag = true;
        while (true) {
            if (temp.no == HeroNode2.no) {
                System.out.printf("节点冲突，冲突序号为: %d", HeroNode2.no);
//                throw new RuntimeException();
                flag = false;
                break;
            }
            if (temp.next == null || temp.next.no > HeroNode2.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            HeroNode2.next = temp.next;
            temp.next = HeroNode2;
        } else {
            System.out.println("节点已存在，添加失败");
        }
    }

    public void list() {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
