package TreeTraversal;
import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
public class TreeTraversal {
    Node root;
    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        Node root = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values to insert into the binary tree (type -1 to stop):");
        while (true) {
            int val = scanner.nextInt();
            if (val == -1) {
                break;
            }
            root = tree.insert(root, val);
        }
        System.out.println("\nInorder traversal:");
        tree.inorder(root);
        System.out.println("\nPreorder traversal:");
        tree.preorder(root);
        System.out.println("\nPostorder traversal:");
        tree.postorder(root);
        scanner.close();
    }
}