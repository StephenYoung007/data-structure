package ityoung.tech.arrayqueue;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(33);
        arrayQueue.addQueue(36);
        arrayQueue.addQueue(33);
        arrayQueue.addQueue(33);
        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.addQueue(33);
        int i = arrayQueue.headQueue();
        System.out.println("i = " + i);
        arrayQueue.showQueue();
    }
}

class ArrayQueue {
    private int front;
    private int rear;
    private int[] arr;
    private int maxSize;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            throw new NullPointerException();
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列满");
            throw new RuntimeException("队列满");
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public void showQueue() {
        for (int i = front; i < front + ((rear - front + maxSize) % maxSize); i++) {
            System.out.println(arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return arr[front];

    }


}
