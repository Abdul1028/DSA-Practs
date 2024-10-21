package BST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//NOT for exam chilll

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a node into the BST
    public void insert(int data) {
        root = insertNode(root, data);
    }

    // Insert a node without recursion
    public Node insertNode(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            return newNode; // If tree is empty, return new node
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // Attach new node to the parent
        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    // Delete a node from the BST
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    // Delete a node without recursion
    private Node deleteNode(Node root, int data) {
        if (root == null) {
            System.out.println(data + " not found in the tree.");
            return root;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    // Find the minimum value node
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Search for a value in the BST
    public boolean search(int data) {
        return searchNode(root, data);
    }

    // Search for a node without recursion
    private boolean searchNode(Node root, int data) {
        Node current = root;
        while (current != null) {
            if (data == current.data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    // Display the tree nodes in a simple format
    public void display() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("BST Nodes: ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Main method to run the menu-driven program
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Search for a node");
            System.out.println("4. Display BST");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    tree.insert(valueToInsert);
                    System.out.println(valueToInsert + " inserted into the BST.");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int valueToDelete = scanner.nextInt();
                    tree.delete(valueToDelete);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int valueToSearch = scanner.nextInt();
                    boolean found = tree.search(valueToSearch);
                    if (found) {
                        System.out.println(valueToSearch + " found in the BST.");
                    } else {
                        System.out.println(valueToSearch + " not found in the BST.");
                    }
                    break;

                case 4:
                    tree.display();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
