import java.util.Scanner;

public class Stack {
    private static final int MAX_SIZE = 100;
    private int[] stackArray;
    private int top;

    public Stack() {
        this.stackArray = new int[MAX_SIZE];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == MAX_SIZE - 1);
    }

    public void push(int item) {
        if (!isFull()) {
            stackArray[++top] = item;
            System.out.println("Pushed " + item + " to the stack.");
        } else {
            System.out.println("Stack is full. Cannot push.");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        System.out.println("Stack is empty. Cannot pop.");
        return -1;
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        System.out.println("Stack is empty.");
        return -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;  // Flag variable to control the loop

        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int number = scanner.nextInt();
                    stack.push(number);
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped " + popped + " from the stack.");
                    }
                    break;

                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element is " + topElement);
                    }
                    break;

                case 4:
                    System.out.println("Current stack size is " + stack.size());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    flag = false;  // Set the flag to false to exit the loop
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
