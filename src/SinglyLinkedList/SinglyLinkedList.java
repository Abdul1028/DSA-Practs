package SinglyLinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    // Add a node at the front of the list
    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add a node at the end of the list
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
    }

    // Add a node at a specific position
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
            System.out.println("Position out of range.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete a node from the front
    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Delete a node from the end
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of range.");
        } else {
            current.next = current.next.next;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Menu-driven interface
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
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
                    System.out.print("Enter value to add at front: ");
                    int dataFront = scanner.nextInt();
                    list.addFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter value to add at end: ");
                    int dataEnd = scanner.nextInt();
                    list.addEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter value to add: ");
                    int dataPos = scanner.nextInt();
                    System.out.print("Enter position: ");
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
                    System.out.print("Enter position to delete: ");
                    int deletePos = scanner.nextInt();
                    list.deleteAtPosition(deletePos);
                    break;
                case 7:
                    System.out.println("Singly Linked List: ");
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
