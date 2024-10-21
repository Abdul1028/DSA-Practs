package DoublyLinkedList;
import java.util.Scanner;
public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Add node at the front
    public void addFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add node at the back
    public void addBack(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Insert node at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addFront(data);
            return;
        } else if (position == size) {
            addBack(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    // Delete node from the front
    public int deleteFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    // Delete node from the back
    public int deleteBack() {
        if (tail == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return data;
    }

    // Delete node at a specific position
    public int deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position.");
            return -1;
        }

        if (position == 0) {
            return deleteFront();
        } else if (position == size - 1) {
            return deleteBack();
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        int data = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return data;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("END");
    }

    // Constructor
    public DoublyLinkedList() {
        this.size = 0;
    }

    // Main function with menu-driven loop
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Front");
            System.out.println("2. Add Back");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete Front");
            System.out.println("5. Delete Back");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    dll.addFront(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    dll.addBack(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int position = sc.nextInt();
                    dll.insertAtPosition(data, position);
                    break;
                case 4:
                    data = dll.deleteFront();
                    if (data != -1) {
                        System.out.println("Deleted from front: " + data);
                    }
                    break;
                case 5:
                    data = dll.deleteBack();
                    if (data != -1) {
                        System.out.println("Deleted from back: " + data);
                    }
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    data = dll.deleteAtPosition(position);
                    if (data != -1) {
                        System.out.println("Deleted from position " + position + ": " + data);
                    }
                    break;
                case 7:
                    dll.display();
                    break;
                case 8:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
