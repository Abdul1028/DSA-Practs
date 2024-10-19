package DoublyLinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Add at the front of the list
    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Add at the end of the list
    public void addEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    // Add at a specific position
    public void addAtPosition(int data, int position) {
        if (position == 1) {
            addFront(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range");
        } else {
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null) {
                current.next.prev = newNode;
            }

            current.next = newNode;
        }
    }

    // Delete a node at the front
    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
    }

    // Delete a node at the end
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.prev.next = null;
    }

    // Delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position == 1) {
            deleteFront();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Add at front");
            System.out.println("2. Add at end");
            System.out.println("3. Add at position");
            System.out.println("4. Delete front");
            System.out.println("5. Delete end");
            System.out.println("6. Delete at position");
            System.out.println("7. Display list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add at front: ");
                    int dataFront = scanner.nextInt();
                    list.addFront(dataFront);
                    break;

                case 2:
                    System.out.print("Enter the value to add at end: ");
                    int dataEnd = scanner.nextInt();
                    list.addEnd(dataEnd);
                    break;

                case 3:
                    System.out.print("Enter the value to add: ");
                    int dataPos = scanner.nextInt();
                    System.out.print("Enter the position: ");
                    int pos = scanner.nextInt();
                    list.addAtPosition(dataPos, pos);
                    break;

                case 4:
                    list.deleteFront();
                    break;

                case 5:
                    list.deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter the position to delete: ");
                    int delPos = scanner.nextInt();
                    list.deleteAtPosition(delPos);
                    break;

                case 7:
                    System.out.println("Doubly Linked List: ");
                    list.display();
                    break;

                case 8:
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
