package SinglyLinkedList;
import java.util.Scanner;
public class SinglyLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node tail;
    private Node head;
    private int size;

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;  // Handle empty list
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int deleteFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int data = head.data;
        head = head.next;
        if (head == null) {  // If the list becomes empty
            tail = null;
        }
        size--;
        return data;
    }

    public int deleteBack() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        if (head.next == null) {  // Only one element in the list
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        Node secondLast = get(size - 2);
        int data = tail.data;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return data;
    }

    public void addAtPosition(int data, int position) {
        if (position == 0) {
            addFront(data);
            return;
        }
        if (position >= size) {
            addBack(data);
            return;
        }
        Node previous = get(position - 1);
        Node newNode = new Node(data, previous.next);
        previous.next = newNode;
        size++;
    }

    public int deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position.");
            return -1;
        }
        if (position == 0) {
            return deleteFront();
        }
        Node previous = get(position - 1);
        int data = previous.next.data;
        previous.next = previous.next.next;
        size--;
        return data;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    SinglyLinkedList() {
        this.size = 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Front");
            System.out.println("2. Add Back");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Back");
            System.out.println("5. Add at Position");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    ll.addFront(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    ll.addBack(data);
                    break;
                case 3:
                    data = ll.deleteFront();
                    if (data != -1) {
                        System.out.println("Deleted from front: " + data);
                    }
                    break;
                case 4:
                    data = ll.deleteBack();
                    if (data != -1) {
                        System.out.println("Deleted from back: " + data);
                    }
                    break;
                case 5:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int position = sc.nextInt();
                    ll.addAtPosition(data, position);
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    data = ll.deleteAtPosition(position);
                    if (data != -1) {
                        System.out.println("Deleted at position " + position + ": " + data);
                    }
                    break;
                case 7:
                    ll.display();
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
