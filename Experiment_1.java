import java.util.Scanner;

class Stack {
    protected int[] arr;
    protected int top, n, data;
    Scanner sc = new Scanner(System.in);

    public Stack() {
        n = 10;
        arr = new int[n];
        top = -1;
    }

    public void push() {
        System.out.print("Enter the number to be inserted: ");
        int data = sc.nextInt();
        if (top == n - 1) {
            System.out.println("Stack Overflow! Cannot insert more items.");
        } else {
            top++;
            arr[top] = data;
            System.out.println("Inserted " + data + " into the stack.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No item to pop.");
        } else {
            data = arr[top];
            top--;
            System.out.println("Popped item: " + data);
        }
    }

    public void traverse() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to display.");
        } else {
            System.out.print("Stack contents (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void overflow() {
        if (top == n - 1) {
            System.out.println("Stack Overflow!!");
            System.out.println("Pop elements to insert new elements!");
            pop();
        } else {
            push();
            System.out.println("Sufficient space to insert elements!");
        }
    }

    public void underflow() {
        if (top == -1) {
            System.out.println("Stack Underflow!!");
            System.out.println("Push elements!");
            push();
        } else {
            traverse();
            System.out.println("No Underflow, elements are present!");
        }
    }
}

public class Experiment_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack S = new Stack();
        int choice;

        do {
            System.out.println("\n--- Stack Operations Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Traverse");
            System.out.println("4. Overflow");
            System.out.println("5. Underflow");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: S.push(); break;
                case 2: S.pop(); break;
                case 3: S.traverse(); break;
                case 4: S.overflow(); break;
                case 5: S.underflow(); break;
                case 6:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 6);

        sc.close();
    }
}
