import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert at end
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Insert at given position (1-based)
    void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at given position
    void deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            System.out.println("Position out of range!");
            return;
        }

        temp.next = temp.next.next;
    }

    // Left shift (rotate left)
    void leftShift() {
        if (head == null || head.next == null)
            return;

        Node temp = head;
        head = head.next;
        temp.next = null;

        Node end = head;
        while (end.next != null)
            end = end.next;

        end.next = temp;
    }

    // Right shift (rotate right)
    void rightShift() {
        if (head == null || head.next == null)
            return;

        Node prev = null;
        Node curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        curr.next = head;
        head = curr;
    }

    // Display list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Insert at Position");
            System.out.println("3. Delete at Position");
            System.out.println("4. Left Shift");
            System.out.println("5. Right Shift");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPos(val, pos);
                    break;

                case 3:
                    System.out.print("Enter position to delete: ");
                    list.deleteAtPos(sc.nextInt());
                    break;

                case 4:
                    list.leftShift();
                    System.out.println("List shifted left.");
                    break;

                case 5:
                    list.rightShift();
                    System.out.println("List shifted right.");
                    break;

                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
Output:

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 2
Enter value: 
1
Enter position: 1

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 1
Enter value: 12

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 6
1 -> 12 -> null

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 1
Enter value: 2

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 6
1 -> 12 -> 2 -> null

--- Linked List Menu ---
1. Insert
2. Insert at Position
3. Delete at Position
4. Left Shift
5. Right Shift
6. Display
7. Exit
Enter choice: 
