import java.util.Scanner;

public class Experiment_4 {

    // ==================== DOUBLY LINKED LIST ====================
    static class DLLNode {
        int data;
        DLLNode prev, next;

        DLLNode(int val) {
            data = val;
            prev = next = null;
        }
    }

    static DLLNode dllHead = null;
    static Scanner sc = new Scanner(System.in);

    // Insert at beginning
    static void insertBeginDLL(int val) {
        DLLNode newNode = new DLLNode(val);
        newNode.next = dllHead;
        if (dllHead != null)
            dllHead.prev = newNode;
        dllHead = newNode;
    }

    // Insert at end
    static void insertEndDLL(int val) {
        DLLNode newNode = new DLLNode(val);
        if (dllHead == null) {
            dllHead = newNode;
            return;
        }
        DLLNode temp = dllHead;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete at beginning
    static void deleteBeginDLL() {
        if (dllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        dllHead = dllHead.next;
        if (dllHead != null)
            dllHead.prev = null;
        System.out.println("Deleted from beginning.");
    }

    // Delete at end
    static void deleteEndDLL() {
        if (dllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        DLLNode temp = dllHead;
        while (temp.next != null)
            temp = temp.next;
        if (temp.prev != null)
            temp.prev.next = null;
        else
            dllHead = null;
        System.out.println("Deleted from end.");
    }

    // Display DLL
    static void displayDLL() {
        if (dllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Doubly Linked List: ");
        DLLNode temp = dllHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ==================== CIRCULAR LINKED LIST ====================
    static class CLLNode {
        int data;
        CLLNode next;

        CLLNode(int val) {
            data = val;
            next = null;
        }
    }

    static CLLNode cllHead = null;

    // Insert at beginning
    static void insertBeginCLL(int val) {
        CLLNode newNode = new CLLNode(val);
        if (cllHead == null) {
            cllHead = newNode;
            newNode.next = cllHead;
        } else {
            CLLNode temp = cllHead;
            while (temp.next != cllHead)
                temp = temp.next;
            newNode.next = cllHead;
            temp.next = newNode;
            cllHead = newNode;
        }
    }

    // Insert at end
    static void insertEndCLL(int val) {
        CLLNode newNode = new CLLNode(val);
        if (cllHead == null) {
            cllHead = newNode;
            newNode.next = cllHead;
        } else {
            CLLNode temp = cllHead;
            while (temp.next != cllHead)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = cllHead;
        }
    }

    // Delete at beginning
    static void deleteBeginCLL() {
        if (cllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        if (cllHead.next == cllHead) {
            cllHead = null;
            System.out.println("Deleted last node.");
            return;
        }
        CLLNode last = cllHead;
        while (last.next != cllHead)
            last = last.next;
        cllHead = cllHead.next;
        last.next = cllHead;
        System.out.println("Deleted from beginning.");
    }

    // Delete at end
    static void deleteEndCLL() {
        if (cllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        if (cllHead.next == cllHead) {
            cllHead = null;
            System.out.println("Deleted last node.");
            return;
        }
        CLLNode temp = cllHead;
        while (temp.next.next != cllHead)
            temp = temp.next;
        temp.next = cllHead;
        System.out.println("Deleted from end.");
    }

    // Display CLL
    static void displayCLL() {
        if (cllHead == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Circular Linked List: ");
        CLLNode temp = cllHead;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != cllHead);
        System.out.println();
    }

    // ==================== MAIN MENU ====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, val;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Doubly Linked List (DLL)");
            System.out.println("2. Circular Linked List (CLL)");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int dllChoice;
                    do {
                        System.out.println("\n--- Doubly Linked List Menu ---");
                        System.out.println("1. Insert at Beginning");
                        System.out.println("2. Insert at End");
                        System.out.println("3. Delete at Beginning");
                        System.out.println("4. Delete at End");
                        System.out.println("5. Display");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter choice: ");
                        dllChoice = sc.nextInt();

                        switch (dllChoice) {
                            case 1:
                                System.out.print("Enter value: ");
                                val = sc.nextInt();
                                insertBeginDLL(val);
                                break;
                            case 2:
                                System.out.print("Enter value: ");
                                val = sc.nextInt();
                                insertEndDLL(val);
                                break;
                            case 3:
                                deleteBeginDLL();
                                break;
                            case 4:
                                deleteEndDLL();
                                break;
                            case 5:
                                displayDLL();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (dllChoice != 6);
                    break;

                case 2:
                    int cllChoice;
                    do {
                        System.out.println("\n--- Circular Linked List Menu ---");
                        System.out.println("1. Insert at Beginning");
                        System.out.println("2. Insert at End");
                        System.out.println("3. Delete at Beginning");
                        System.out.println("4. Delete at End");
                        System.out.println("5. Display");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter choice: ");
                        cllChoice = sc.nextInt();

                        switch (cllChoice) {
                            case 1:
                                System.out.print("Enter value: ");
                                val = sc.nextInt();
                                insertBeginCLL(val);
                                break;
                            case 2:
                                System.out.print("Enter value: ");
                                val = sc.nextInt();
                                insertEndCLL(val);
                                break;
                            case 3:
                                deleteBeginCLL();
                                break;
                            case 4:
                                deleteEndCLL();
                                break;
                            case 5:
                                displayCLL();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (cllChoice != 6);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
