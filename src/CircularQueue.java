import java.util.Scanner;

public class CircularQueue {

    private Integer[] queue;
    private int maxSize;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        queue = new Integer[size];
        maxSize = size;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) { // First element
                front = 0;
            }
            rear = (rear + 1) % maxSize;
            queue[rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        } else {
            int item = queue[front];
            if (front == rear) { // Queue has only one element
                front = rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
            System.out.println("Dequeued: " + item);
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        } else {
            return queue[front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue: ");
            int i = front;
            do {
                System.out.print(queue[i] + " ");
                i = (i + 1) % maxSize;
            } while (i != (rear + 1) % maxSize);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the circular queue: ");
        int size = scanner.nextInt();
        CircularQueue circularQueue = new CircularQueue(size);

        boolean flag = true;
        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to enqueue: ");
                    int item = scanner.nextInt();
                    circularQueue.enqueue(item);
                    break;
                case 2:
                    int dequeuedItem = circularQueue.dequeue();
                    if (dequeuedItem != -1) {
                        System.out.println("Dequeued item: " + dequeuedItem);
                    }
                    break;
                case 3:
                    int peekItem = circularQueue.peek();
                    if (peekItem != -1) {
                        System.out.println("Front item: " + peekItem);
                    }
                    break;
                case 4:
                    circularQueue.display();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
