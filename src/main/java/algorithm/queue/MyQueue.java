package algorithm.queue;

public class MyQueue {
    private final int[] arr = new int[4];
    private int front = -1;
    private int rear = -1;

    public MyQueue() {}

    public void enQueue(int x) {
        if(rear == arr.length-1) {
            throw new RuntimeException("Queue is full");
        }
        rear++;
        arr[rear] = x;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("Queue is empty");
        }
        front++;
        return arr[front];
    }
}
