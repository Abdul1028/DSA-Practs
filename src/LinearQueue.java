import java.util.Scanner;

public class LinearQueue {

    private Integer[] queue;
    private int maxSize;
    private int front;
    private int rear;

    public LinearQueue(int size) {
        queue = new Integer[size];
        maxSize = size;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full.");
        } else {
            queue[++rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // or throw an exception
        } else {
            int item = queue[front++];
            System.out.println("Dequeued: " + item);
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // or throw an exception
        } else {
            return queue[front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        LinearQueue linearQueue = new LinearQueue(size);

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
                    linearQueue.enqueue(item);
                    break;
                case 2:
                    int dequeuedItem = linearQueue.dequeue();
                    if (dequeuedItem != -1) {
                        System.out.println("Dequeued item: " + dequeuedItem);
                    }
                    break;
                case 3:
                    int peekItem = linearQueue.peek();
                    if (peekItem != -1) {
                        System.out.println("Front item: " + peekItem);
                    }
                    break;
                case 4:
                    linearQueue.display();
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
