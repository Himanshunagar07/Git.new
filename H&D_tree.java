//code to find height and depth of tree and tree element take by user define.
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class UserInputTree {

    // Function to find height of tree
    static int height(Node root) {
        if (root == null)
            return -1;   // height in terms of edges

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Function to find depth of a node
    static int depth(Node root, int key, int level) {
        if (root == null)
            return -1;

        if (root.data == key)
            return level;

        int left = depth(root.left, key, level + 1);
        if (left != -1)
            return left;

        return depth(root.right, key, level + 1);
    }

    // Create tree using user input (level order)
    static Node createTree() {
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();

        System.out.print("Enter root value: ");
        int value = sc.nextInt();
        Node root = new Node(value);
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();

            System.out.print("Enter left child of " + current.data + " (-1 for no node): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                q.add(current.left);
            }

            System.out.print("Enter right child of " + current.data + " (-1 for no node): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                q.add(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree();

        System.out.println("Height of Tree: " + height(root));

        System.out.print("Enter node value to find depth: ");
        int key = sc.nextInt();

        int d = depth(root, key, 0);
        if (d != -1)
            System.out.println("Depth of node " + key + " is: " + d);
        else
            System.out.println("Node not found!");
    }
}
